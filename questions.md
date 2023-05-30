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

Les Services Web Full Rest (ou RESTful Web Services) sont un style d'architecture pour la création et l'exposition de services web. Ils suivent les principes de l'architecture REST (Representational State Transfer), qui est basée sur le protocole HTTP et les principes du web.

Les contraintes imposées par les Services Web Full Rest sont les suivantes :

Architecture client-serveur : Le client et le serveur sont séparés, ce qui permet une indépendance et une évolutivité des parties frontale et arrière.

- Stateless (Sans état) : Chaque requête du client au serveur doit contenir toutes les informations nécessaires pour comprendre et traiter cette requête. Le serveur ne conserve pas l'état des clients entre les requêtes.

- Interface uniforme : Le serveur expose une interface uniforme qui est utilisée par le client pour interagir avec les ressources. Cette interface est généralement basée sur les méthodes HTTP telles que GET, POST, PUT et DELETE.

- Système de cache : Les réponses peuvent être mises en cache par le client, le serveur ou les caches intermédiaires pour améliorer les performances.

- Couches (Layered system) : Le système peut être composé de plusieurs couches, chaque couche ayant sa propre responsabilité et fonction. Cela permet une meilleure scalabilité et modularité.

- Code à la demande (Optionnel) : Le serveur peut envoyer du code exécutable au client, par exemple sous la forme de scripts JavaScript, pour étendre les fonctionnalités du client.

En respectant ces contraintes, les Services Web Full Rest offrent une architecture légère, évolutive et interopérable, ce qui en fait un choix populaire pour la création d'APIs web.

C'est une architecture qui se base sur des échanges d'informations basés sur les protocoles HTTP pour la création de services Web. Les contraintes principales
de REST sont: un modèle client-serveur, un système sans état (chaque requête contient toutes les informations
nécessaires pour y répondre), la mise en cache, l'interface uniforme, le système en couches et le code à la demande
existe d'autres outils comme Gradle ou Ant pour Java, ou NPM pour JavaScript.
L'avantage est de simplifier la gestion des bibliothèques dépendantes et d'assurer une plus grande cohérence et
reproductibilité entre les environnements de développement.

**Qu’est-ce qu’une application classique Entreprise Java Application ? Donner un exemple d’usage avec
web service, JSP, JavaBean, EJB et JMS.**

Une application classique d'entreprise en Java est une application qui suit le modèle d'architecture multi-niveaux (ou architecture en couches) pour répondre aux besoins d'une entreprise. Cette architecture se compose généralement des couches suivantes :

- Couche de présentation : Cette couche gère l'interface utilisateur de l'application et la communication avec les utilisateurs. Les technologies couramment utilisées dans cette couche sont les JSP (JavaServer Pages) pour la génération des vues et les web services pour permettre l'intégration avec d'autres systèmes.

- Couche métier : Cette couche contient la logique métier de l'application. Elle est responsable du traitement des données et des règles métier. Dans cet exemple, les JavaBeans sont utilisés pour encapsuler les données et les traitements métier dans des objets réutilisables.

- Couche d'accès aux données : Cette couche gère l'accès aux sources de données, telles que les bases de données. Elle est responsable de la persistance des données. Dans une application classique d'entreprise Java, les EJB (Enterprise JavaBeans) sont couramment utilisés pour gérer l'accès aux données de manière sécurisée et transactionnelle.

- Couche d'intégration : Cette couche est chargée de l'intégration avec d'autres systèmes ou services. Dans cet exemple, les web services sont utilisés pour permettre la communication avec d'autres applications ou services via des protocoles standardisés.

- Couche de messagerie : Cette couche gère la communication asynchrone entre les différentes parties de l'application ou avec d'autres applications externes. Dans cet exemple, JMS (Java Message Service) est utilisé pour la communication asynchrone entre les différents composants de l'application.

**Qu’est-ce que Spring ? qu’apporte Spring boot vis-à-vis de Spring ?**

Spring est un framework open source pour le développement d'applications Java. Il fournit une infrastructure complète pour la création d'applications d'entreprise robustes et évolutives. Spring se base sur des concepts tels que l'injection de dépendances (Dependency Injection), l'inversion de contrôle (Inversion of Control), et offre de nombreux modules pour faciliter le développement d'applications dans différents domaines (web, persistance des données, sécurité, etc.).

Spring Boot, quant à lui, est une extension de Spring qui vise à simplifier le processus de configuration et de déploiement des applications Spring. Il fournit des conventions intelligentes par défaut et une configuration automatique basée sur les opinions pour permettre aux développeurs de créer rapidement des applications Spring autonomes.

Les avantages de Spring Boot par rapport à Spring sont les suivants :

Configuration simplifiée : Spring Boot réduit la quantité de configuration manuelle requise pour démarrer une application Spring en fournissant des configurations par défaut intelligentes basées sur les conventions. Cela permet de gagner du temps et de réduire la complexité de la configuration initiale.

Démarrage rapide : Spring Boot offre un mécanisme de démarrage rapide (auto-configuration) qui détecte automatiquement les bibliothèques et les frameworks utilisés dans le projet, et configure automatiquement l'application en conséquence. Cela permet aux développeurs de se concentrer davantage sur le développement des fonctionnalités métier plutôt que sur la configuration de l'infrastructure.

Prise en charge intégrée : Spring Boot intègre de nombreux composants et bibliothèques couramment utilisés, tels que Tomcat ou Jetty pour le serveur web embarqué, Hibernate pour la persistance des données, et Spring Security pour la sécurité. Cela facilite l'utilisation et l'intégration de ces composants sans nécessiter de configurations supplémentaires.

Métriques et surveillance : Spring Boot fournit des fonctionnalités intégrées pour la surveillance des applications, y compris la génération de métriques et de journaux. Cela facilite le suivi des performances et le dépannage des applications.

En résumé, Spring Boot est une extension de Spring qui simplifie le processus de configuration et de déploiement des applications Spring. Il offre des conventions intelligentes par défaut, une configuration automatique et une intégration simplifiée avec des composants couramment utilisés. Cela permet aux développeurs de créer rapidement des applications Spring autonomes et de se concentrer davantage sur le développement des fonctionnalités métier.

**Qu’est-ce que Spring Boot ? Quels sont les points communs/différences entre JEE et Spring Boot ?**

Spring Boot est un framework Java qui simplifie le développement d'applications autonomes basées sur Spring. Il offre une configuration automatique et un démarrage rapide. Les points communs entre JEE et Spring Boot sont qu'ils visent tous deux à faciliter le développement d'applications d'entreprise, offrent des fonctionnalités de persistance, de sécurité et d'intégration. Cependant, Spring Boot est considéré comme plus léger, offre une configuration automatique basée sur les conventions, permet une exécution indépendante de serveur, et bénéficie d'un écosystème actif. En revanche, JEE est souvent lié à des serveurs d'applications Java EE spécifiques et nécessite une configuration plus explicite.

**Qu’est-ce qu’une annotation ? Quels apports présentent les Annotations ?**

Une annotation est une forme de métadonnées ajoutée au code Java avec le symbole `@` suivi du nom de l'annotation. Les annotations fournissent des informations supplémentaires sur les éléments du code et offrent plusieurs avantages tels que l'amélioration de la documentation, la simplification de la configuration, la validation à la compilation, la génération de code et une meilleure intégration avec les outils de développement.

**Comment fait-on pour créer un Web Service Rest avec Spring Boot ?**

Pour créer un Web Service REST avec Spring Boot, vous devez suivre les étapes suivantes :

- Configurez un projet Spring Boot avec les dépendances nécessaires pour le support du Web et des services REST.
- Créez un contrôleur en annotant une classe avec @RestController pour définir les points d'entrée de votre API REST.
- Implémentez les méthodes du contrôleur en utilisant des annotations telles que @RequestMapping pour définir les mappings URL et les méthodes HTTP correspondantes.
- Utilisez les annotations telles que @PathVariable, @RequestParam, et @RequestBody pour récupérer les paramètres et les données des requêtes.
- Testez votre Web Service REST en exécutant l'application Spring Boot et en utilisant un client REST pour envoyer des requêtes et vérifier les réponses.

**Qu’est-ce qu’un container de Servlet ? Comment fonctionne un container de Servlet ?**

Un container de Servlet est un composant d'un serveur d'applications qui gère le cycle de vie, la configuration et l'exécution des servlets dans une application Java EE.

Le fonctionnement d'un container de Servlet implique la réception de la requête, le routage vers le servlet approprié, l'instanciation et l'initialisation du servlet, le traitement de la requête, la génération de la réponse, l'envoi de la réponse au client et, éventuellement, la destruction du servlet.

Le container de Servlet offre des fonctionnalités telles que la gestion des sessions, la gestion des filtres, la gestion des erreurs et la sécurité.

Son rôle principal est de simplifier et d'abstraire la gestion des servlets, permettant aux développeurs de se concentrer sur la logique métier de leur application.

**Expliquer la philosophie « Convention over Configuration » de Spring boot ?**

La philosophie "Convention over Configuration" (Convention plutôt que Configuration) est un principe clé de Spring Boot. Elle vise à réduire la configuration explicite et redondante en fournissant des conventions et des configurations par défaut intelligentes. Au lieu de demander aux développeurs de spécifier explicitement chaque détail de configuration, Spring Boot offre des valeurs par défaut sensibles et des conventions basées sur les bonnes pratiques. Cela permet aux développeurs de se concentrer davantage sur le code métier plutôt que sur la configuration.

Spring Boot suit des conventions préétablies pour la configuration des divers composants, tels que la configuration automatique des beans, la détection automatique des dépendances et la configuration du conteneur d'application. Cela permet de gagner du temps et de simplifier le développement en évitant la configuration fastidieuse et répétitive. Toutefois, Spring Boot reste flexible et offre la possibilité de personnaliser la configuration lorsque cela est nécessaire.


**Expliquer ce qu’il se passe lors de l’exécution «SpringApplication .run(App.class,args) » Qu’est ce qu’un DAO ? En quoi est-ce intéressant d’utiliser ce pattern ? Qu’est ce qu’un Singleton ? Que permet de réaliser les Entity dans Spring boot ? Est-ce spécifique à SpringBoot ?**

Lors de l'exécution de SpringApplication.run(App.class, args), Spring Boot initialise l'application en démarrant le conteneur Spring, en analysant la configuration de l'application et en lançant l'application en tant qu'application Spring Boot autonome.

Plus précisément, voici ce qui se passe lors de cette exécution :

Spring Boot analyse la classe App.class fournie en paramètre, qui est généralement une classe de configuration principale annotée avec @SpringBootApplication.
Le conteneur Spring est initialisé, ce qui crée un contexte d'application Spring.
Le contexte d'application Spring est configuré en fonction des annotations et des configurations définies dans la classe App.class et les classes associées.
Les dépendances de l'application sont résolues et instanciées, y compris les beans configurés et les composants détectés par Spring.
L'application est démarrée et est prête à répondre aux requêtes ou à exécuter les tâches configurées.
Maintenant, passons aux autres concepts :

DAO (Data Access Object) : Le DAO est un modèle de conception (pattern) qui permet d'encapsuler l'accès aux données de la couche de persistance dans une application. Le DAO fournit une interface entre la logique métier de l'application et la source de données, qu'il s'agisse d'une base de données, d'un service web ou d'autres mécanismes de stockage. Il permet d'abstraire les détails spécifiques de l'accès aux données et facilite le maintien, la réutilisation et les tests de l'application.

Intérêt du pattern DAO : L'utilisation du pattern DAO permet de séparer la logique métier de l'accès aux données, améliorant ainsi la maintenabilité, la modularité et la testabilité du code. Il facilite également la gestion des transactions, la gestion des erreurs et permet de remplacer plus facilement la source de données sous-jacente sans impacter la logique métier.

Singleton : Singleton est un modèle de conception (pattern) qui garantit qu'une classe ne possède qu'une seule instance dans une application. Cette instance unique est accessible globalement. Le Singleton est souvent utilisé pour des objets partagés et des ressources uniques dans une application.

Entity dans Spring Boot : Dans Spring Boot, les entités (Entity) sont des classes POJO (Plain Old Java Objects) qui représentent des objets persistants, généralement mappés à des tables dans une base de données relationnelle. Les entités sont annotées avec des annotations spécifiques telles que @Entity, @Table, @Column, etc., pour définir la structure de la table, les relations avec d'autres entités et les propriétés de l'entité.

Spécificité de l'utilisation des entités dans Spring Boot : L'utilisation d'entités dans Spring Boot est basée sur le framework Java Persistence API (JPA), qui est une spécification standard pour la gestion de la persistance des données dans les applications Java. Spring Boot facilite l'intégration de JPA avec des bibliothèques telles que Hibernate pour la gestion des entités. Cependant, l'utilisation d'entités n'est pas spécifique à Spring Boot, car elle peut également être utilisée dans d'autres frameworks Java basés sur JPA pour gérer la persistance des données.

**Combien d’instances avez-vous crées lors de l’usage de «Service » en Spring boot? Pourquoi ?**

Lors de l'utilisation du mot-clé Service en Spring Boot, une seule instance est généralement créée par défaut par le conteneur Spring, à moins que vous spécifiiez une configuration différente.

Le rôle d'une classe annotée avec @Service est d'implémenter la logique métier de votre application. Ces classes sont généralement utilisées pour encapsuler des opérations complexes ou des traitements spécifiques. L'annotation @Service indique à Spring que cette classe est un bean de service.

Par défaut, Spring crée une seule instance d'un bean lorsqu'il est annoté avec @Service et est géré par le conteneur Spring. Cette instance est généralement partagée par l'ensemble de l'application et peut être injectée dans d'autres composants, tels que des contrôleurs ou d'autres services.

Cette approche garantit une utilisation efficace des ressources et permet le partage de l'état et des données entre différents composants de l'application.

Cependant, il est important de noter que vous pouvez également configurer le scope (portée) d'un bean @Service en utilisant l'annotation @Scope. Par exemple, vous pouvez définir le scope comme @Scope("prototype") pour créer une nouvelle instance à chaque demande d'injection.

Dans l'ensemble, le comportement par défaut de Spring est de créer une seule instance d'un bean @Service pour une utilisation globale dans l'application, à moins que vous ne spécifiiez explicitement une autre configuration de scope.

**Que fournit le CRUD Repository de Spring boot ? Que sont les CRUD ?**

Le CRUD Repository de Spring Boot est une interface fournie par Spring Data JPA qui offre un ensemble de méthodes prédéfinies pour effectuer des opérations CRUD (Create, Read, Update, Delete) sur une entité dans une base de données.

Le CRUD Repository fournit les fonctionnalités suivantes :

Create (Créer) : Il offre des méthodes pour créer de nouveaux enregistrements dans la base de données. Par exemple, la méthode save() permet d'ajouter un nouvel enregistrement ou de mettre à jour un enregistrement existant.

Read (Lire) : Il offre des méthodes pour récupérer des enregistrements depuis la base de données. Par exemple, les méthodes findById() et findAll() permettent respectivement de rechercher un enregistrement par son identifiant et de récupérer tous les enregistrements d'une entité.

Update (Mettre à jour) : Il offre des méthodes pour mettre à jour des enregistrements existants dans la base de données. Par exemple, la méthode save() permet également de mettre à jour un enregistrement en lui attribuant de nouvelles valeurs.

Delete (Supprimer) : Il offre des méthodes pour supprimer des enregistrements de la base de données. Par exemple, les méthodes deleteById() et delete() permettent de supprimer respectivement un enregistrement par son identifiant et un enregistrement spécifié.

En utilisant le CRUD Repository, vous n'avez pas besoin d'écrire manuellement des requêtes SQL pour effectuer ces opérations de base sur la base de données. Spring Data JPA se charge de générer automatiquement les requêtes SQL appropriées en fonction des méthodes définies dans l'interface de repository.

Les opérations CRUD (Create, Read, Update, Delete) sont des opérations de base dans la persistance des données. Elles représentent les actions fondamentales que l'on peut effectuer sur les données d'une application.

Create (Créer) : Il s'agit de l'opération permettant de créer de nouveaux enregistrements dans la base de données.
Read (Lire) : Il s'agit de l'opération permettant de récupérer les données existantes de la base de données.
Update (Mettre à jour) : Il s'agit de l'opération permettant de modifier les enregistrements existants dans la base de données.
Delete (Supprimer) : Il s'agit de l'opération permettant de supprimer des enregistrements de la base de données.
L'utilisation des opérations CRUD est courante dans le développement d'applications pour gérer la persistance des données et assurer la manipulation des données de manière cohérente et fiable.

**Qui réalise l’implémentation de la méthode findByProperty lors de la création d’un repository en Spring Boot ?**

Lors de la création d'un repository avec Spring Boot, l'implémentation de la méthode findByProperty est générée automatiquement par Spring Data JPA.

Spring Data JPA est une extension de Spring qui facilite l'interaction avec les bases de données relationnelles en fournissant une couche d'abstraction sur JPA. Elle utilise des conventions de nommage pour générer des requêtes SQL à partir des noms de méthodes définis dans les interfaces de repository.

Pour générer automatiquement la méthode findByProperty, Spring Data JPA analyse le nom de la méthode et crée dynamiquement une requête qui correspond à la propriété spécifiée. Par exemple, si vous avez une entité Person avec une propriété name, en définissant une méthode findByname dans votre interface de repository, Spring Data JPA générera automatiquement la requête SQL pour rechercher les enregistrements correspondants dans la base de données en fonction de la propriété name.

Cela permet d'éviter d'écrire manuellement des requêtes SQL pour les opérations CRUD courantes, car Spring Data JPA les génère automatiquement en fonction des méthodes définies dans l'interface du repository.

Il est important de noter que pour que cette génération automatique fonctionne correctement, les noms des méthodes dans l'interface de repository doivent suivre les conventions de nommage de Spring Data JPA. Si vous utilisez une convention de nommage incorrecte ou si vous avez besoin d'une requête plus complexe, vous pouvez utiliser des annotations spécifiques telles que @Query pour définir manuellement la requête à exécuter.

**Comment gère -t-on les relations One To One, One to Many et Many to Many avec JPA ?**

JPA (Java Persistence API) est une spécification de la plateforme Java EE qui définit une interface de programmation pour la gestion de la persistance des objets dans les bases de données relationnelles. JPA fournit des annotations et des annotations XML pour mapper les objets Java aux tables de la base de données, y compris la gestion des relations entre les entités.

Voici comment vous pouvez gérer les différentes relations avec JPA :

Relation One-to-One (Un à un) :

Dans JPA, vous pouvez gérer une relation One-to-One en utilisant l'annotation @OneToOne dans vos entités.
Par exemple, si vous avez une entité Person avec une relation One-to-One vers l'entité Address, vous pouvez annoter le champ address dans Person avec @OneToOne et utiliser l'annotation @JoinColumn pour spécifier la clé étrangère.
Relation One-to-Many (Un à plusieurs) :

Pour gérer une relation One-to-Many avec JPA, vous pouvez utiliser l'annotation @OneToMany.
Par exemple, si vous avez une entité Customer avec une relation One-to-Many vers l'entité Order, vous pouvez annoter le champ orders dans Customer avec @OneToMany et utiliser l'annotation @JoinColumn pour spécifier la clé étrangère.
Relation Many-to-Many (Plusieurs à plusieurs) :

JPA gère les relations Many-to-Many en utilisant une table de jointure.
Vous pouvez utiliser l'annotation @ManyToMany pour annoter les champs correspondants dans les entités qui ont cette relation.
Par exemple, si vous avez une entité Student avec une relation Many-to-Many vers l'entité Course, vous pouvez annoter le champ courses dans Student avec @ManyToMany et utiliser l'annotation @JoinTable pour spécifier la table de jointure.
Il est important de noter que ces annotations JPA définissent la relation entre les entités au niveau de l'objet. JPA se charge de mapper ces relations dans la base de données en créant les tables appropriées et en gérant les clés étrangères.

Il est également possible d'utiliser des annotations supplémentaires, telles que mappedBy et cascade, pour configurer plus en détail le comportement des relations, la suppression en cascade, etc.

Il est recommandé de consulter la documentation officielle de JPA pour obtenir plus de détails et d'exemples sur la gestion des relations avec JPA, car il existe différentes stratégies de mapping et d'autres options de configuration en fonction de vos besoins spécifiques.

**Qu’est ce qu’une Architecture SOA ? Qu’est ce qu’une architecture Micro Service ? Il y a-t-il d’autres architectures existantes ? Quels sont leurs avantages/inconvénients ?**

Une architecture SOA (Service-Oriented Architecture) est un style d'architecture logicielle qui favorise la construction d'applications en tant que services modulaires et interconnectés. Dans une architecture SOA, les différentes fonctionnalités de l'application sont conçues comme des services indépendants qui peuvent être réutilisés et combinés pour créer des applications plus complexes. Les services communiquent entre eux via des protocoles standardisés tels que SOAP (Simple Object Access Protocol) ou REST (Representational State Transfer).

D'autre part, une architecture Microservices (ou architecture à micro-services) est un style d'architecture logicielle dans lequel une application est divisée en un ensemble de services autonomes, indépendants et de petite taille, appelés microservices. Chaque microservice est responsable d'une fonctionnalité spécifique et communique avec les autres microservices via des mécanismes légers tels que les API REST. Chaque microservice peut être développé, déployé, mis à l'échelle et géré indépendamment, ce qui favorise la flexibilité et la facilité de maintenance des systèmes.

Il existe également d'autres architectures logicielles, notamment :

Architecture monolithique : Il s'agit d'une architecture traditionnelle où une application est développée comme une entité unique et autonome. Toutes les fonctionnalités sont regroupées dans un seul code source et déployées ensemble. Les avantages de cette approche sont sa simplicité et sa facilité de déploiement initial. Cependant, cela peut entraîner une complexité accrue à mesure que l'application grandit et devient plus difficile à maintenir.

Architecture en couches (Layered architecture) : Cette architecture divise une application en différentes couches, telles que la présentation, la logique métier et l'accès aux données. Chaque couche offre des fonctionnalités spécifiques et communique avec les couches adjacentes. Cela permet une séparation des responsabilités et une facilité de maintenance, mais peut entraîner une dépendance accrue entre les couches.

Architecture orientée événements (Event-driven architecture) : Cette approche se concentre sur les événements et les échanges asynchrones entre les composants du système. Les composants réagissent aux événements en fonction de leurs abonnements, ce qui permet une communication souple et une évolutivité élevée. Cependant, la gestion des événements peut être complexe et nécessite une bonne compréhension du flux d'événements.

Les avantages et inconvénients de chaque architecture peuvent varier en fonction des besoins spécifiques d'un projet. Cependant, en général :

- SOA favorise la réutilisation des services, la flexibilité et l'intégration, mais peut entraîner une complexité accrue en raison de la nécessité de gérer des contrats de service et des protocoles de communication.
- Les microservices permettent une évolutivité et une maintenance plus faciles, une indépendance des services et une flexibilité de déploiement, mais peuvent augmenter la complexité opérationnelle et nécessiter une bonne gestion de la communication entre les microservices.
- Les architectures monolithiques sont simples à développer et à déployer, mais peuvent être difficiles à maintenir et à faire évoluer.