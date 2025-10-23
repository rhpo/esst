#include <stdio.h>
#include <signal.h>
#include <unistd.h>

void terminate() {
	signal(SIGINT, SIG_DFL);
}

int main()  {

	signal(SIGINT, terminate);

	while (1) {
		printf("Working...\n");
		sleep(1);
	}
}
