
# La línea de a continuación indica que se realizará la configuración de vagrant, el "2" indica la versión
Vagrant.configure("2") do |config|

  # Indica el sistema operativo (vagrant box) a usar
  #config.vm.box = "velocity42/xenial64" 
  config.vm.box = "xcoo/bionic64"

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
