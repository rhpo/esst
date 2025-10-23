#include <unistd.h>
#include <wait.h>
#include <stdio.h>
#include <stdlib.h>

int main() {

	pid_t pid;
	pid_t pidW;
	for (int i = 0; i < 5; i++) {
		pid = fork();

		// child
		if (!pid) {
			printf("My PID: %d | PID of Father: %d\n", getpid(), getppid());
			exit(0);
		} else if (pid == -1) {
			printf("Error in forking!\n");
		} else if (pid > 0 && i == 2) {
			pidW = pid;
		}
	}

	wait(&pidW);
}
