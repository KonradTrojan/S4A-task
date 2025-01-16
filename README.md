## Smart4Aviation - recruitment task

Dane wejściowe pobierane są z pliku .txt. Format danych w pliku powinien 
odpowiadać standardowemu wejściu np.

```
5 7
1 2 3 2 4
Q 1 5 2
Q 2 3 2
C 2 3
P 3 5 3
Q 2 4 4
A 2 5 6
Q 1 5 8
```

### Jak uruchomić program?

- pobrać z repozytorium archiwum [smart4aviation-1.0.3.jar](smart4aviation-1.0.3.jar);
- otworzyć terminal w folderze z pobranym plikem;
- uruchomić program komendą ``java -jar smart4aviation-1.0.3.jar``;

Powyższa komenda domyślnie pobierze dane z pliku ``input.txt``, który powinien znajdować się w tym samym 
folderze, z którego wykonywana jest komenda.

Jako argument można też podać ścieżkę względną do pliku z danymi wejściowymi np.

- ``java -jar smart4aviation-1.0.3.jar input1.txt``