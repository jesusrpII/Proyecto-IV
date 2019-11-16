Pull request para el ejercicio 1 adicional.
Autor: [David Luque](https://github.com/davidluque1)


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

Al hacer los tests con Maven, la aplicación se encarga automáticamente de realizar el recuento de la cobertura. Yéndonos a la carpeta imageCo/target/site/jacoco/index.html podemos ver una página web con el resultado obtenido. En mi caso, el compañero ya ha testeado todo el código que se ejecutaría en el curso normal de la aplicación, pero no hay ningún código que testee excepciones. Para ello, he añadido las siguientes líneas de código, las cuales provocan una excepción:

```
//test que comprueba que se produce una excepción en ExcepcionCargarImagen
    @Test
    public void ExcepcionCargarImagenURL(){
        System.out.println("Cargar imagen de prueba");
        String url = "httpds://image.freepik.com/foto-gratis/camino-rural-tematico-otono-concepto-cordillera_53876-23187.jpg";
        imageC o = new imageC();
        o.cargarImagenURL(url);
        
    }
```

Antes de añadir estas líneas, la cobertura era:

![1](https://github.com/davidluque1/RepoPruebas/blob/master/antes_jacoco.png)

Tras, añadirlas:

![2](https://github.com/davidluque1/RepoPruebas/blob/master/despues_jacoco.png)

Con lo cual vemos que aumentó un 2%. Se podría mejorar más aún añadiendo los test de excepciones restantes.
