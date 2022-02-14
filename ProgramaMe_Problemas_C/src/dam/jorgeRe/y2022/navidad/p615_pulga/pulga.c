
#include <stdio.h>

int	main(void)
{
	int cases, i;

	// FILE* fd = fopen("./datos.txt", "r");
	// if (fd == NULL) {
	// 	printf("no such file.");
	// 	return 0;
	// }

	// fscanf(fd, "%d\n", &cases);
	scanf("%d\n", &cases);
	// printf("%d\n", cases);

	i = 0;
	int n, f, t;
	while (i < cases)
	{
		// fscanf(fd, "%d %d %d\n", &n, &f, &t);
		scanf("%d %d %d\n", &n, &f, &t);
		// printf("%d %d %d\n", n, f, t);
		printf("%d\n", (t % (n + 1)) * f);

		i++;
	}

	return (0);
}