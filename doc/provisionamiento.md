## Provisionamiento de máquinas virtuales

Para el provisionamiento se ha hecho uso de [Vagrant](https://www.vagrantup.com/) para la creación de las máquinas virtuales y [Ansible](https://www.ansible.com/) para el provisionamiento de las máquinas. Para los pasos siguientes se va a suponer que se dispone ya instalada en la máquina local Vagrant, Ansible y VirtualBox.

### Elección del SO

Se va a utilizar ubuntu como sistema operativo ya que es un sistema con el que estoy familiarizado, ofrece buen rendimiento y no suele dar muchos problemas. En principio probé con las dos últimas versiones ubuntu xenial (16.04) y ubuntu Bionic (18.04) (ubuntu 14 la descarté ya que es bastante antigua y es una buena práctica tratar de tener el SO más actualizado).

Vagrant ofrece en [https://app.vagrantup.com/boxes/search] bastantes sistemas operativos (llamados box por vagrant), en mi caso busqué estas dos distribuciones de ubuntu en su version minimal ya que pesan mucho menos que el SO completo ya que no incluyen todas las funciones pero para nuestro caso van a ser más que suficientes.

Para realizar la prueba únicamente será necesario cambiar en VagrantFile el sistema operativo para la máquina virtual, en mi caso los vagrant box: Minimal Ubuntu 16.04[velocity42/xenial64](https://app.vagrantup.com/velocity42/boxes/xenial64) y Minimal Ubuntu 18.04 [xcoo/bionic64](https://app.vagrantup.com/xcoo/boxes/bionic64).

Para crear la máquina se han realizado todos los pasos que se explican más adelante, para comparar los dos SO he utilizado Apache Benchmark. Para ello es necesario tener dicho programa instalado (bastaría con sudo apt install apache2-utils). 

He realizado la prueba ejecutando "ab -n 10000 -c 100 localhost:8080/status" que realiza 10000 peticiones a nuestra API en concreto solicitando el recurso status con un nivel de concurrencia de 100.

(Nota: Se puede acceder a las máquinas virtuales por ssh mediante "vagrant ssh")

Resultados en Ubuntu 16.04:

![Imagen1](https://github.com/jesusrpII/Proyecto-IV/blob/master/doc/images/abub16.png)

Resultados en Ubuntu 18.04:

![Imagen2](https://github.com/jesusrpII/Proyecto-IV/blob/master/doc/images/abub18.png)




### Vagrant

#### Vagrantfile

Para la creación de una máquina virtual con Vagrant es necesario crear un archivo llamado [VagrantFile](https://github.com/jesusrpII/Proyecto-IV/blob/master/Vagrantfile), en el se halla toda la información necesaria para crear la máquina virtual:

```yaml

 # La línea de a continuación indica que se realizará la configuración de vagrant, el "2" indica la versión
Vagrant.configure("2") do |config|

  # Indica el sistema operativo (vagrant box) a usar
  config.vm.box = "velocity42/xenial64" 
  #config.vm.box = "xcoo/bionic64"

  # Direccionamos el puerto 2222 de la máquina local con el puerto 22 de la máquina virtual, será utilizado para las conexiones ssh
  config.vm.network "forwarded_port", guest: 22, host:2222, id: "ssh", auto_correct: true
  # Direccionamos el puerto 8080 de nuestra máquina local al puerto 8080 de la máquina virtual, será utilizado para la API, de este modo con localhost:8080 podremos acceder a la API
  config.vm.network "forwarded_port", guest: 8080, host:8080, id: "apache", auto_correct: true

  # Indicamos que ansible será el encargado de realizar el provisionamiento
  config.vm.provision "ansible" do |ansible|
     # Le indicamos el path del playbook de ansible
     ansible.playbook = "ansible/playbook.yml"
   end

    # Para el provider que es virtualbox
  config.vm.provider "virtualbox" do |v|
    # Indicamos que las máquinas virtuales utilicen 2048 MB (2GB) de memoria
    v.memory = 2048
  end
end
```

En el archivo se encuentra detallado para que se utiliza cada línea.

#### Inventory

En vagrant es necesario un archivo llamado Invetory que le indique a vagrant en que máquinas se va a utilizar el vagrantfile, en mi caso no será necesario crearlo ya que este archivo es generado automáticamente para que la configuración afecte a todas las máquinas creadas.

### Ansible

Ansible será el encargado de provisionar nuestras máquinas virtuales, para ello necesitará conocer que necesitan nuestras máquinas esto es indicado mediante un archivo llamado "playbook", el playbook que utilizo es:

``` yaml
#configuracion para todos los host
- hosts: all
  become: yes

  # las tareas que se ejecutarán en las máquinas virtuales serán
  tasks:
  - name: actualizar apt
    apt:
      update_cache: yes
      upgrade: yes

  #  - name: instalar jdk8
   #  apt: name=openjdk-8-jdk state=present
    
  - name: Instalación de Maven
    apt: name=maven state=latest
 
  - name: git installation
    apt: name=git state=present

  - name: clonar repositorio del proyecto
    git:
     command: git clone https://github.com/jesusrpII/Proyecto-IV.git
     dest: ./ProyectoIV/

  - name: instalar proyecto
    command: mvn clean install

  - name: iniciar api
    command: mvn spring-boot:start

´´´

La estructura de este fichero es sencilla, primero se indica en que máquinas virtuales afecta (en este caso todas) y para cada máquina ejecutará todos las tareas (task).
Las tareas ejecutadas instalan y actualizan las aplicaciones necesarias para levantar el servicio, cada nombre (name) es una breve descripción de lo que realizan.

### Bibliografía

https://www.vagrantup.com/docs/provisioning/ansible_intro.html
https://www.adictosaltrabajo.com/2015/09/04/creacion-de-entornos-de-integracion-con-ansible-y-vagrant/
https://www.redeszone.net/vagrant/




