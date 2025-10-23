#include <unistd.h>
#include <wait.h>
#include <stdio.h>
#include <stdlib.h>

int main() {

	for (int i = 0; i < 5; i++) {
		pid_t pid = fork();

		// child
		if (!pid) {
			printf("My PID: %d | PID of Father: %d\n", getpid(), getppid());
			exit(0);
		}
	}

	while (wait(NULL) != -1);
}
