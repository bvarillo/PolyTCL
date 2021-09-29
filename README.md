# PolyTCL

Minecraft plugin that compute path in a railway network.

## Configuration

./plugins/PolyTCL/config.yml

```yml
 mapName: #Name of the csv file describing the network, default : map.csv
 separator: #the separator used in the csv map file, default : ,
 namesSeparator: #The separator used in the csv names filr, default : \t
 namesFile: #Name of the csv file containing the names of the stations
```

## Devloppement

### Prerequisites

- Java (at least version 11) : https://adoptopenjdk.net/
- Maven : https://maven.apache.org/
- An editor (VSCode with the 'Extension Pack for Java' extension is cool : https://code.visualstudio.com/docs/languages/java)

### Compilation
To build the .jar file in the target folder use 
```
mvn package
```
