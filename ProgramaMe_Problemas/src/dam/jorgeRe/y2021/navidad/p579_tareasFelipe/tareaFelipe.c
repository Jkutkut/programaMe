/**
 * ================
 * Ejercicio: TareasFelipe
 * Author: Jkutkut
 */

#include <stdio.h>

typedef struct {
    int priority;
    int time;
} eSorted;


int main(void) {
    int testL, prio, time, next;
    int arrLen;
    int i, j, k, valid;
    
    eSorted elements[100];
    eSorted e;

    while (1) {
        scanf("%d\n", &testL);
        
        if (testL == 0) {
            break;
        }

        arrLen = 0; // The current length of the array used
        for (i = 0; i < testL; i++) {
            scanf("%d %d", &prio, &time);
            
            // find location for element
            for (j = 0; j < 100; j++) { // O(n)
                valid = 0;

                if (j == arrLen) { // If end reached
                    valid = 1; // add the new element at the end
                }
                else if (elements[j].priority < prio ||
                        (elements[j].priority == prio && elements[j].time > time)) {
                    // move all elements till end one to the right
                    for (k = arrLen; k > j; k--) {
                        elements[k].priority = elements[k - 1].priority;
                        elements[k].time = elements[k - 1].time;
                    }
                    valid = 1; // add the new element
                }

                if (valid) {
                    elements[j].priority = prio;
                    elements[j].time = time;
                    arrLen++; // Now array has one more space used
                    break;
                }
            }
        }

        for (i = 0; i < arrLen; i++) {
            printf("%d %d\n", elements[i].priority, elements[i].time);
        }
        printf("---\n");
    }

    return 0;
}