# -*- mode: ruby -*-
# vi: set ft=ruby :

# All Vagrant configuration is done below. The "2" in Vagrant.configure
# configures the configuration version (we support older styles for
# backwards compatibility). Please don't change it unless you know what
# you're doing.
Vagrant.configure("2") do |config|

  #config.vm.box = "ubuntu/trusty64"
  #config.vm.box = "ubuntu/xenial64"
  #config.vm.box = "ubuntu/bionic64"
  
  config.vm.network "forwarded_port", guest: 22, host:2222, id: "ssh", auto_correct: true
 
  #Use Apache
  config.vm.network "forwarded_port", guest: 80, host:8080, id: "apache", auto_correct: true
 
  config.vm.define "continuous_integration" do |continuous_integration|
    continuous_integration.vm.provision "ansible" do |ansible|
      ansible.inventory_path = "ansible/environments/continuous_integration/inventory"
      ansible.verbose = 'vvv'
      ansible.playbook = "ansible/continuous_integration.yml"
    end
 
    config.vm.provider "virtualbox" do |v|
      v.memory = 2048
    end
  end
end


