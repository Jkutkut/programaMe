/**
 * ================
 * Ejercicio: 580 fotoMafalda
 * Author: Jkutkut
 * ================
 */

/*
[x] Todos los retratados en una foto deben representar a un personaje diferente del mural.
[x] Para que no queden demasiado vacías, al menos debe haber 3 personas en cada foto.
[x] No se hacen fotos si no hay alguien en el puesto de Mafalda. Cuando llega alguien que quiere aparecer como ella, se hace inmediatamente la foto, siempre que se cumpla la condición anterior.
[x] Si cuando llega alguien por Mafalda no hay gente suficiente en la foto, se espera hasta que lo haya.
[x] Si cuando le toca el turno a alguien su personaje está ocupado, espera, dejando pasar a los siguientes de la cola, hasta que su puesto queda libre.
*/

#include <stdio.h>

#define NAME_L 9 // Max length of name
#define N_PEOPLE 7 // Amount of available spots on mural

#define MAFALDA 0
#define FELIPE 1
#define MANOLITO 2
#define SUSANITA 3
#define MIGUELITO 4
#define LIBERTAD 5
#define GUILLE 6

int pIndex(char p[NAME_L]) {
    switch (p[0]) {
        case 'M': // Mafalda, Manolito
            switch (p[2]) {
                case 'f':
                    return MAFALDA; // Mafalda
                case 'n':
                    return MANOLITO; // Manolito
                default:
                    return MIGUELITO; // Miguelito
            }
        case 'F':
            return FELIPE; // Felipe
        case 'S':
            return SUSANITA; // Susanita
        case 'L':
            return LIBERTAD; // Libertad
        default:
            return GUILLE; // Guille
    }
};

int main(void) {
    int people, i, j, index;
    char name[NAME_L];

    int peopleOnMural, photosTaken;

    unsigned int mural[N_PEOPLE];
    unsigned int queue[N_PEOPLE]; 

    while (1) {
        scanf("%d", &people);
        if (people == 0) {
            break;
        }

        // ResetVars
        for (i = 0; i < N_PEOPLE; i++) {
            mural[i] = 0;
            queue[i] = 0;
        }

        peopleOnMural = 0;
        photosTaken = 0;

        for (i = 0; i < people; i++) {
            scanf("%s", name);

            index = pIndex(name);

            if (mural[index] == 0) { // if no one on mural, add it
                mural[index] = 1;
                peopleOnMural++;
            }
            else { // Add it to the queue
                queue[index]++;
            }

            while (peopleOnMural >= 3 && mural[MAFALDA]) {
                photosTaken++;
                peopleOnMural = 0;
                
                for (j = 0; j < N_PEOPLE; j++) { // fill mural with queue while it gets emptied
                    mural[j] = 0; // Empty mural
                    if (queue[j]) { // If someone waiting here
                        mural[j] = 1;
                        peopleOnMural++;
                        queue[j]--;
                    }
                }

            }
        }

        //Count people left without photo using peopleOnMural variable
        for (i = 0; i < N_PEOPLE; i++) {
            peopleOnMural += queue[i];
        }

        printf("%d %d\n", photosTaken, peopleOnMural);
    }

    return 0;
};