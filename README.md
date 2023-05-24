# ASI
## Rendu de : 
- Maxime BATTU
- Axel ESCH
- Quentin MIGUEL LOPEZ
- Morgane QUELENNEC

# Atelier 1

## Questions & réponses

**Qu’est-ce que le pattern MVC ? Quels avantages présente-t-il ? Qu’est-ce que le Web dynamique ?
pourquoi est-il intéressant ? Comment sont récupérés les fichiers par le Web Browser en Web
statique ? Quels sont les avantages d’utiliser du Web Statique avec des services REST ?**

Le MVC est une architecture permettant de créer une application en 3-tier.
Le modèle (Model) représente les données et la logique métier, la vue (View) représente l'interface utilisateur et le
contrôleur (Controller) agit comme un intermédiaire entre le modèle et la vue.
Les avantages de l'utilisation du pattern MVC incluent la séparation des préoccupations (facilitant le développement et
la maintenance respectant ainsi certains principes SOLID), la réutilisabilité du code et la possibilité de travailler simultanément sur différentes parties de
l'application.

Le web dynamique est un type de site web dont le contenu peut être modifié en temps réel ou en fonction de la demande
de l'utilisateur. Il est souvent construit à l'aide de technologies comme PHP, JavaScript, ASP.NET, JSP, etc.
L'avantage du web dynamique est sa flexibilité - le contenu peut être mis à jour et personnalisé facilement.
Il est particulièrement utile pour les sites Web avec beaucoup de contenu interactif, comme les sites de commerce
électronique, les réseaux sociaux, les blogs, etc.

Dans un site web statique, tous les fichiers (HTML, CSS, JavaScript, images, etc.) sont pré-existants et sont servis
tels quels au navigateur par le serveur web. Le navigateur récupère ces fichiers via des requêtes HTTP(S) standards,
et les affiche ensuite à l'utilisateur.

L'une des principales raisons d'utiliser un site web statique avec des services REST est la performance.
Les sites web statiques sont rapides à charger car ils ne nécessitent pas de temps de traitement serveur pour générer le contenu.
De plus, ils peuvent être facilement mis en cache pour une performance accrue. Combiner un site web statique avec des 
services REST offre la possibilité d'avoir des éléments dynamiques lorsque cela est nécessaire. Par exemple, vous pouvez
utiliser un service REST pour récupérer des données dynamiques et les afficher sur votre site web statique. Cette approche est souvent utilisée dans le développement moderne de l'interface utilisateur avec des bibliothèques/frameworks comme React, Angular ou Vue.js, où le site web statique est servi comme une "Single Page Application" qui communique avec un backend via des services REST.

**Qu’est-ce que les architectures N-Tiers ? Quels avantages apportent-elles ?**

Les architectures N-Tiers sont un type d'architecture de système informatique dans lequel une application ou un système
est divisé en "n" nombre de "tiers" ou de couches distinctes. Le terme "n-tiers" est utilisé pour indiquer qu'il peut y avoir un nombre quelconque de couches. Chaque couche a un rôle spécifique et interagit avec les couches qui lui sont adjacentes.

L'architecture N-Tiers offre plusieurs avantages :

- Séparation des préoccupations : Chaque couche a un rôle spécifique, ce qui permet de séparer les préoccupations.
Cela facilite la maintenance et le développement de l'application, car les modifications apportées à une couche n'affectent pas les autres
- Réutilisabilité : Les composants de chaque couche peuvent être réutilisés dans différentes parties de l'application 
ou dans d'autres applications, ce qui améliore l'efficacité du développement.
- Scalabilité : Il est possible de mettre à l'échelle chaque couche indépendamment en fonction des besoins.
Par exemple, si une application nécessite plus de capacité de traitement, on peut ajouter plus de ressources à la couche de logique métier sans affecter les autres couches.
- Flexibilité : Il est plus facile de mettre à jour ou de remplacer une couche sans perturber les autres.
Par exemple, on peut remplacer la base de données par une autre sans avoir à modifier l'interface utilisateur ou la logique métier.

**Comment fonction l’AJAX ?**

AJAX est l'acronyme de Asynchronous JavaScript And XML. C'est une technique qui permet aux pages web de communiquer avec
le serveur sans avoir à recharger toute la page. Elle rend les applications web plus réactives et interactives.
Lorsqu'un événement se produit sur une page web (comme un clic sur un bouton),
JavaScript peut créer une nouvelle instance de l'objet `XMLHttpRequest`.

**Qu’est-ce que JEE ? Comment fonctionne un serveur JEE ? Qu’est-ce qu’un Web Container en JEE ?**

JEE (Java Enterprise Edition) est une plateforme de développement d'applications d'entreprise en Java. Un serveur JEE
est un environnement d'exécution pour les applications JEE. Un conteneur JEE, ou Web Container, gère l'exécution des composants web de l'application dans un environnement JEE.

**Qu’est-ce que Springboot ? quelles différences avec JEE ?**

Spring Boot est un framework Java pour le développement d'applications. Il simplifie le processus de développement
en fournissant une configuration par défaut et des fonctionnalités intégrées. JEE est une spécification complète pour
le développement d'applications d'entreprise en Java, nécessitant un serveur JEE complet. Spring Boot est plus léger et flexible, tandis que JEE est plus complet et adapté aux applications d'entreprise complexes.

**Qu’apport Thymeleaf à Springboot ?**


Thymeleaf apporte un moteur de templates pour la création de vues HTML dans les applications Spring Boot.l permet de
générer des pages web dynamiques en intégrant facilement des données provenant du backend dans les templates HTML.

**Que signifie l’annotation @Controller, pourquoi est-elle importante lors de la génération de pas coté
serveur ?**

L'annotation `@Controller` est utilisée en Spring pour marquer une classe en tant que contrôleur.
Elle indique à Spring que la classe est responsable du traitement des requêtes HTTP entrantes et de la génération de réponses appropriées.
L'annotation `@Controller` est importante lors de la génération côté serveur, car elle permet à Spring de détecter et de
gérer les requêtes HTTP. Lorsqu'une requête est reçue, Spring identifie le contrôleur approprié en fonction des mappings définis et invoque la méthode appropriée pour générer la réponse. L'annotation @Controller joue donc un rôle clé dans le routage des requêtes et la génération des réponses dans une application Spring côté serveur.

**Que représente le répertoire ‘src/main/resources’ dans un projet SpringBoot ? Quelles sont les
informations stockées à cet endroit ?**

Le répertoire "src/main/resources" dans un projet Spring Boot est l'emplacement par défaut pour stocker les ressources non Java de l'application. Il contient des fichiers et des ressources qui sont généralement utilisés dans le cadre du développement de l'application, mais qui ne font pas partie du code source Java lui-même.

Les types de ressources couramment stockées dans ce répertoire sont :

- Fichiers de configuration : Des fichiers de configuration tels que application.properties ou application.yml peuvent être placés ici pour configurer le comportement de l'application.
- Fichiers statiques : Des fichiers statiques tels que des fichiers HTML, CSS, JavaScript, des images ou d'autres ressources statiques peuvent être stockés ici pour être servis par l'application.
- Modèles de vues : Les templates utilisés pour la génération des vues peuvent être placés dans ce répertoire. Par exemple, les fichiers HTML utilisés avec Thymeleaf ou les fichiers de vues JSP.
- Fichiers de données : Des fichiers de données statiques peuvent être stockés ici, par exemple des fichiers de propriétés ou des fichiers de données au format CSV ou JSON.

# Atelier 2

## Questions & réponses

**Qu’est ce que des Services Web Full Rest ? Quelles sont les contraintes imposées par ce type de
service ?**

C'est une architecture qui se base sur des échanges d'informations basés sur les protocoles HTTP pour la création de services Web. Les contraintes principales
de REST sont: un modèle client-serveur, un système sans état (chaque requête contient toutes les informations
nécessaires pour y répondre), la mise en cache, l'interface uniforme, le système en couches et le code à la demande
(facultatif).

**Qu’est ce qu’un gestionnaire de dépendance ? Maven est-il le seul ? Quel est l’avantage d’utiliser un
gestionnaire de dépendances ? Quelles sont les grandes étapes de fonctionnement de Maven ?**

Un gestionnaire de dépendances est un outil qui automatise le processus d'installation, de mise à niveau,
de configuration ou de suppression de logiciels. Maven est un exemple populaire, mais il 
existe d'autres outils comme Gradle ou Ant pour Java, ou NPM pour JavaScript.
L'avantage est de simplifier la gestion des bibliothèques dépendantes et d'assurer une plus grande cohérence et
reproductibilité entre les environnements de développement.

**Qu’est ce qu’une application classique Entreprise Java Application ? Donner un exemple d’usage avec
web service, JSP, JavaBean, EJB et JMS.**



**Qu’est ce que Spring ? qu’apporte Spring boot vis-à-vis de Spring ?**

**Qu’est ce que Spring Boot ? Quels sont les points communs/différences entre JEE et Spring Boot ?**

**Qu’est ce qu’une annotation ? Quels apports présentent les Annotations ?**

**Comment fait-on pour créer un Web Service Rest avec Spring Boot ?**

**Qu’est ce qu’un container de Servlet ? Comment fonctionne un container de Servlet ?**

**Expliquer la philosophie « Convention over Configuration » de Spring boot ?**

**Expliquer ce qu’il se passe lors de l’exécution «SpringApplication .run(App.class,args) »
Qu’est ce qu’un DAO ? En quoi est-ce intéressant d’utiliser ce pattern ? Qu’est ce qu’un Singleton ?
Que permet de réaliser les Entity dans Spring boot ? Est-ce spécifique à SpringBoot ?**

**Combien d’instances avez-vous crées lors de l’usage de «Service » en Spring boot? Pourquoi ?**

**Que fournit le CRUD Repository de Spring boot ? Que sont les CRUD ?**

**Qui réalise l’implémentation de la méthode findByProperty lors de la création d’un repository en
Spring Boot ?**

**Comment gère -t-on les relations One To One, One to Many et Many to Many avec JPA ?**

**Qu’est ce qu’une Architecture SOA ? Qu’est ce qu’une architecture Micro Service ? Il y a-t-il d’autres
architectures existantes ? Quels sont leurs avantages/inconvénients ?**

