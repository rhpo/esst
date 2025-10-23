#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <signal.h>
#include <wait.h>

int main() {

	printf("Starting...\n");
	pid_t child = fork();

	// child
	if (child == 0) {
		sleep(5);
		printf("FILS: P[%d], C[%d]\n", getpid(), getppid());

		exit(0);
	} 

	sleep(2);
	printf("PERE: P[%d], C[%d]\n", getpid(), getppid());

	wait(NULL);
}
