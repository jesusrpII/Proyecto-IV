Pull request para el ejercicio 1 adicional.
Autor: David Luque (https://github.com/davidluque1)


## Test de cobertura

La idea es ejecutar un test que compruebe qué cantidad de código de las clases se comprueba al ejecutar los tests. Se va a usar [jacoco](https://www.jacoco.org/jacoco/trunk/index.html) para comprobar el porcentaje de cobertura del compañero. Para instalarlo, se añade el siguiente código al archivo pom.xml:

~~~~
<plugin>
				<groupId>org.jacoco</groupId>
				<artifactId>jacoco-maven-plugin</artifactId>
				<version>0.8.2</version>
				<executions>
					<execution>
						<goals>
							<goal>prepare-agent</goal>
						</goals>
					</execution>
					<!-- attached to Maven test phase -->
					<execution>
						<id>report</id>
						<phase>test</phase>
						<goals>
							<goal>report</goal>
						</goals>
					</execution>
				</executions>
			</plugin>
~~~~

Al hacer los tests con Maven, la aplicación se encarga automáticamente de realizar el recuento de la cobertura. Yéndonos a la carpeta imageCo/target/site/jacoco/index.html podemos ver una página web con el resultado obtenido. En mi caso, el compañero ya ha testeado todo el código que se ejecutaría en el curso normal de la aplicación, así que no hay nada que pueda testear adicionalmente.
