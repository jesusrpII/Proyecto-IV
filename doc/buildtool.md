### Herramienta de construcción

Como herramienta de construcción se a utilizado [Maven](https://maven.apache.org/). 
Maven es una herramienta de construcción open source que se encarga de compilar y generar los ejecutables de nuestro proyecto. 
Se ha elegido ya que es una herramienta facil de instalar y utilizar. 
"apt-get install maven" (para instalar) y "mvn archetype:generate" (que puede ir junto a otros parametros para generar la estructura de nuestro proyecto)

En mi caso para esta fase del proyecto he utilizado el IDE Netbeans con lo cual el proceso ha sido incluso más sencillo, de hecho el fichero de dependencias pom.xml se genera solo y se actualiza al añadir nuevas librerías (por ejemplo al añadir junit), de no hacerlo se deberían añadir las dependencias manualmente.

Toda la información necesaria para construir el proyecto se encuentra en el archivo pom.xml que ya se ha comentado anteriormente (se ha generado automáticamente) contiene todas las dependencias, así como otra información como puede ser el groupID o artifactId entre otras:


### Spring boot

A la hora de crear el proyecto Spring Boot en mi caso he utilizado el IDE Netbeans, únicamente he tenido que instalar un plugin (spring-boot) y las dependencias se han añadido automáticamente en [pom.xml](https://github.com/jesusrpII/Proyecto-IV/tree/master/imageCo/pom.xml).
Sin embargo, si he tenido que modificar algunas dependencias ya que no funcionaba bien del todo, por ejemplo para arrancar el proyecto springboot no contemplaba poder pararlo (con stop) para ello se ha añadido lo siguiente (algo muy simple, pero si no te das cuenta puedes pasarte mucho tiempo sin saber por que no funciona):

```yaml
<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <addResources>true</addResources>
                    <fork>true</fork>
                </configuration>
			</plugin>
		</plugins>
	</build>
```

Para construir y ejecutar los test: mvn clean install
Para ejecutar los test únicamente: mvn test
Para arranca la aplicación spring boot: mvn spring-boot:start
Para parar spring-boot: mvn spring-boot: stop




