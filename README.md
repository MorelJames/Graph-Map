# 🗺️ Application d'Interaction avec un Graph-Map  

Ce projet Java (Maven) permet de charger un **fichier CSV représentant un graphe** et d'interagir avec ses données à travers une **interface graphique (IHM)**.  
L'application permet d'explorer les lieux, d'analyser leurs relations et de créer des itinéraires de manière interactive.  

---

## 🚀 Fonctionnalités  

- 📂 **Chargement CSV** : lecture d'un fichier CSV pour construire un graphe de lieux et de relations  
- 🔍 **Exploration de voisins** : afficher uniquement les voisins d'un lieu à *N sauts*  
- 🏙️ **Vue simplifiée** : afficher uniquement les lieux sans les liens entre eux  
- ⚖️ **Comparaison de lieux** : comparer deux lieux sur un nombre de sauts défini, en fonction de :
  - **Ouverture** : nombre de voisins  
  - **Gastronomie** : nombre de voisins à caractère gastronomique  
  - **Culture** : nombre de voisins à caractère culturel  
- 🗺️ **Création d’itinéraires** : possibilité de générer un chemin en choisissant plusieurs lieux à visiter  
- 🖥️ **Interface Graphique (IHM)** : interaction simple et visuelle avec le graphe  
- ✅ **Tests Unitaires** : couverture des principales fonctionnalités pour assurer la fiabilité du code  

---

## 🛠️ Stack Technique  

- **Langage :** Java 8
- **Build Tool :** Maven  
- **Tests :** JUnit  
- **IHM :** Java Swing
