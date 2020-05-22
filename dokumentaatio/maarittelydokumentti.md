# Määrittelydokumentti

Projeḱtin tarkoitus on toteuttaa yksi tai useampi "time stretching" algoritmi. Eli äänen nopeuden/keston muuttaminen ilman että sen korkeus muuttuu.

## Algoritmit

Toiminnallisuus toteutetaan vaihevokooderilla(phase vocoder) joka perustuu lyhytaikaiseen Fourier-muunnokseen.

## Input/Output

Ohjelma lukee äänitiedoston(wav tai mp3) ja tekee siitä venytetyn kopion.

## Lähteet
- https://sethares.engr.wisc.edu/vocoders/Transforms.pdf
- https://en.wikipedia.org/wiki/Phase_vocoder
- http://users.spa.aalto.fi/vpv/ask-sanasto.htm