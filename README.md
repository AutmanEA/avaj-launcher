# avaj-launcher
42 Project AVAJ LAUNCHER - introduction to java by ael-atmi

# Information

## Java (JRE, JDK...)

https://thegreatapi.com/blog/whats-the-difference-between-java-jre-jdk-and-openjdk/

## UML Class Diagram

https://www.geeksforgeeks.org/system-design/unified-modeling-language-uml-class-diagrams/

# Installation

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

# Compilation

## Build

## Execution
