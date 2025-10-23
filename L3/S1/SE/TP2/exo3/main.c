#include <stdio.h>
#include <signal.h>
#include <unistd.h>
#include <sys/wait.h>
#include <stdlib.h>

#define MAX_TENTATIVES 3
int tentatives = 1;

void manual() {
	printf("(X) Manual termination...\n");
	exit(0);
}

void automatic() {
	printf("Warning! Please enter a message (left: %d).\n", MAX_TENTATIVES - tentatives);
	
	if (tentatives++ == MAX_TENTATIVES) {
		printf("Automatic termination...\n");
		exit(0);
	}

	alarm(5);
}

int main() {

	char* reply;
	
	signal(SIGALRM, automatic);
	alarm(5);

	printf("Enter [Y/n] to continue...\n");
	scanf("%s", reply);

	alarm(0);
	manual();

	return 0;
	
}
