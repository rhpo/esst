#include <stdio.h>
#include <signal.h>
#include <unistd.h>
#include <sys/wait.h>
#include <stdlib.h>

pid_t f1, f2;

void on_f2_sigusr1() {
    printf("Signal SIGUSR1 Recu (je suis fils2).\n");
    kill(f1, SIGUSR2);
}

void on_f1_sigusr2() {
    printf("Signal SIGUSR2 Recu depuis fils2 (je suis fils1).\n");
}

int main() {
    f1 = fork();
    if (f1 == 0) { // fi1
        signal(SIGUSR2, on_f1_sigusr2);
        pause();
        exit(0);
    }

    f2 = fork();
    if (f2 == 0) { // f2
        signal(SIGUSR1, on_f2_sigusr1);
        pause();
        exit(0);
    }

	// temps pour F2 pour qu"il ajoute sonn handlerrrrr
    sleep(1);

    kill(f2, SIGUSR1);

    while (wait(NULL) != -1);
}
