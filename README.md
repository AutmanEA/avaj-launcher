# avaj-launcher
42 Project AVAJ LAUNCHER - introduction to java by ael-atmi

# Introduction

Le but de ce projet 42 est de suivre un ```diagramme de classe UML``` afin de programmer une simulation en ```java```, ce qui nous permet de découvrir à la fois l'écritude de code depuis une ```architecture``` donnée ainsi que le ```java```.

Pour le contexte, cette simulation montre des aéronefs qui se comportent différement selon une météo et communiquent avec une tour de contrôle pour le changement d'état.

# Information

## Java (JRE, JDK...)

https://thegreatapi.com/blog/whats-the-difference-between-java-jre-jdk-and-openjdk/

## UML Class Diagram

https://www.geeksforgeeks.org/system-design/unified-modeling-language-uml-class-diagrams/

# Installation de Java

L'environnement cible est Linux pour l'installation de Java et de toutes les dépendances.

## OpenJDK

https://www.geeksforgeeks.org/installation-guide/how-to-install-openjdk-in-linux/

L'installation d'openJDK, version open-source de JDK (Java Developper Kit), contenant tout le nécessaire pour Java:
* compilation (javac)
* execution (JRE - Java Runtime Environment)

### version

```bash
java --version
> openjdk 25.0.2 2026-01-20
> OpenJDK Runtime Environment (build 25.0.2+10-Ubuntu-124.04)
> OpenJDK 64-Bit Server VM (build 25.0.2+10-Ubuntu-124.04, mixed mode, sharing)
```

### installation

> Commandes d'installation openJDK

```bash
sudo apt install openjdk-25-jdk
```

### misc

> Pour mettre par défault l'openJDK ou consulter les informations.

Voir la liste des version de Java installées :
```bash
sudo update-alternatives --config java
```

Configurer la variable d'environnement :
```bash
sudo nano /etc/environment
```
Puis, sur nano ajouter la ligne à la suite :
```
JAVA_HOME=\"/usr/lib/jvm/java-25-openjdk-amd64\"
```

### vscode extension

J'utilise l'extention de microsoft : "Extension Pack for Java"

## Plant UML (visualiser sur vscode)

### vscode extention

J'utilise l'extention de jebbs : "PlantUML"

Nécessite Java (normalement OK) et graphviz:

```bash
sudo apt install graphviz
```
Redémarrer vscode et les plant UML pourront être prévisualisés.

# Programme

En Java, il existe des solutions de build (maven, gradle) mais pour l'apprentissage voulu dans ce projet par l'école 42, nous compilons et executons "à la main"

## Compilation

### Création du fichier source.txt

Création d'un fichier pour une compilation en masse
```bash
find . -name "*.java" > sources.txt
```

Puis compiler avec la commande ```javac```.
```bash
javac @source.txt
```
(le '@' signifie qu'il s'agit bien d'un fichier)

Il est possible de spécifier un dossier de destination avec ```-d <destination>```
```bash
javac -d bin @source.txt
```

Cela va générer des ```.class``` qui servent à l'execution

## Execution

Une fois la compilation faite, executez simplement le programme avec ```java``` en spécifiant l'entrypoint (ici ```Main```).
```bash
java Main <argument>
```

### Argument

Ce programme prend un fichier ```scenario``` en entrée qui doit suivre un format précis:
```txt
<nombre de simulation>
<type de aircraft> <nom> <longitude> <latitude> <height>
...
<type de aircraft> <nom> <longitude> <latitude> <height>
```

Nombre de simulation, première ligne du fichier
- ```nombre de simulation``` = nombre positif

Pour chaque aircraft :
- ```type de aircraft``` = string
- ```nom``` = string
- ```longitude``` = nombre positif
- ```latitude``` = nombre positif
- ```height``` = nombre positif

et le programme vous aura généré un fichier ```simulation.txt```.

# Commentaire sur l'exercice

Comme très probablement tout projet professionnel réel, il y a des problèmes avec le diagramme donné, j'ai donc décidé de fournir avec ce projet le diagramme du projet 42 original (global.puml) et de fournir une version finale post-traitée, comme une version "livrable" (d'ailleurs nommé livrable.puml)

J'imagine que nous fournir un diagramme avec des informations impossibles ou volontaires fausses fait entièrement parti de l'exercice, ainsi, si vous faites le projet, gardez en tête qu'il s'agit uniquement de mon interprétation d'un livrable et de garder comme unique diagramme valide celui fourni par le sujet, ainsi de comprendre par vous-même pourquoi certaines informations semblent erronées.
