# TP1 Diviser pour régner

## Entrée du problème

 - l, h deux entiers strictement positifs
 - n, un entier positifs
 - les coordonnées (entières) des n points (xi, yi),  0 < xi < l, 0 < yi < h

## Question 1 :

Les coordonnées des points  étant des nombres entiers positifs commencant à (0,0), Le rectangle de surface maximale doit avoir deux point sur l'axe des abscisses.
Si ce n'est pas le cas le rectangle  ne sera pas de surface maximale puisque la surafce comprise entre les point (0,0), (0,h) (l,h) et (l,0) ne sera pas comprise dans le rectangle.

Nous savons que le rectangle de surface maximale a un côté de longueur (longueur du côté sur l'axe des abscisses).
Il nous faut alors trouver le point qui a l'ordonnée la plus basse ainsi que le point qui a l'ordonnée la plus haute.

Grâce à cette information, il nout faut donc calculer h x l où h = ordmax.

Algorithme :

s = 0
Pour i entre 0 et n - 1
    Pour j entre i et n - 1
        x = tab[i] et y = tab[j];
        l = tab[j].abs - tab[i].abs
        h = max(tab[i].ord, tab[j].ord);
        Pour k entre i et j
            Si tab[k].ord > h
                h = tab[k].ord
        fin Pour
        Si s < l*h
            s = l*h
    Fin Pour
Fin Pour
afficher s.
