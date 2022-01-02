#HAI913 - TP5

REITER Maxime 21604458

DESGENETEZ Charles 21603540

Le projet est un projet Maven

###Question 1 - 2
Pour tester ses questions il suffit de lancer le Main dans src/main/java/Main.java
, On peut y voir une CLI pour intéragir avec le système.

Les logs sont commenté donc on ne peut pas voir en direct les changements pour éviter les problèmes avec Spoon. On peut quand même voir certains fichiers de logs dans logs/

###Question 3 - 5
Lorsqu'on lance le main dans src/main/java/spoon/Spoon.java, cela créer la version instrumentalisé de notre programme (avec les logs dans chaque méthodes/initilisation des paramètres).
La nouvelle version est stocké dans afterSpoon/ 

Cependant les import doivent être créer manuellement.

Et on devrait trouver des résultat similaires aux logs de logs/
