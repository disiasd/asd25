Repository della libreria di algoritmi e strutture dati per il corso di "Algoritmi e Strutture di Dati" AA.2024-2025 del Dipartimento di Informatica - Scienza e Ingegneria dell'Università di Bologna. La libreria contiene classi di test, interfacce e classi parzialmente implementate che dovrebbero essere completate dagli studenti. Fare riferimento al materiale disponibile sulla pagina web del corso su [Virtuale](https://virtuale.unibo.it/course/view.php?id=58894) per il background teorico e per le specifiche implementative.

Per testare gli algoritmi di ordinamento su array di interi, compilare SortingTest.java ed eseguire
- java SortingTest data/list.random.txt mergesort
- java SortingTest data/list.random.txt quicksort
- ...


Per testare gli algoritmi di ordinamento generici, compilare GenericSortingTest.java ed eseguire
- java GenericSortingTest data/list.random.txt


Per testare la struttura dati Lista, compilare ListTest.java ed eseguire
- java ListTest data/ListOperations.txt
- Confrontare l'ouptut con il contenuto del file data/ListOperations.log.txt


Per testare la struttura dati Coda, compilare QueueTest.java ed eseguire
- java QueueTest data/QueueOperations.txt
- Confrontare l'ouptut con il contenuto del file data/QueueOperations.log.txt


Per testare la struttura dati Pila, compilare StackTest.java ed eseguire
- java StackTest data/StackOperations.txt
- Confrontare l'ouptut con il contenuto del file data/StackOperations.log.txt

Per testare la struttura dati Albero Binario di Ricerca, compilare TreeTest.java (controllare che la riga 54 sia decommentata) ed eseguire
- java TreeTest data/TreeOperations.txt
- Confrontare l'ouptut con il contenuto del file data/TreeOperations.BST.log.txt
