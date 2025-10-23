#include <stdio.h>
#include <signal.h>
#include <unistd.h>
#include <sys/wait.h>

pid_t son;

void on_tick() {
	printf("Killing my son...\n");
	printf("Son PID: %d\n", son);
	
	kill(son, SIGKILL);
}

int main()  {
	signal(SIGALRM, on_tick);

	son = fork();
	if (!son) {
		int counter = 1;
		while (1) {
			printf("I am son... %d\n", counter++);
			sleep(1);
		}
	} 

	alarm(3);
	wait(NULL);
}




