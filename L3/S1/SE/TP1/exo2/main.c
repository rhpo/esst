#include <unistd.h>
#include <wait.h>
#include <stdio.h>
#include <stdlib.h>

int main() {

	int status;              
	int table[3] = {0, 0, 0};
 
	pid_t f1 = fork();
	if (!f1) {
		exit(5);
	} else {
		waitpid(f1, &status, 0);
		table[0] = WEXITSTATUS(status);

		if (!WEXITSTATUS(status)) {
			printf("Error!");
			return 0;
		}
	}

	pid_t f2 = fork();
	if (!f2) {
		exit(10);
	} else {
		waitpid(f2, &status, 0);
		table[1] = WEXITSTATUS(status);

		if (!WEXITSTATUS(status)) {
			printf("Error!");
			return 0;
		}
	}

	pid_t f3 = fork();
	if (!f3) {
		exit(3);
	} else {
		waitpid(f3, &status, 0);
		table[2] = WEXITSTATUS(status);

		if (!WEXITSTATUS(status)) {
			printf("Error!");
			return 0;
		}
	}

	printf("Result: %d\n", table[0] * table[1] + table[2]);
	
}
