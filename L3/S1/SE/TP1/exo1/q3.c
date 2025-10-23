#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <signal.h>
#include <wait.h>

int main() {

	for (int i = 0; i < 2; i++) {

		printf("Création de fils %d\n", i + 1);
		int pid = fork();

		// child
		if (!pid) {
			printf("fils de pid: %d: hola...\n", getppid());
			sleep(5);
			printf("fils de pid: %d: ciao!\n", getppid());

			exit(0);
		}

		wait(NULL);
		printf("Fin de fils %d\n\n\n", i + 1);

	}
}
