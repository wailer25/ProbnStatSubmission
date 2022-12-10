[x, y] = nLogNGraph(2, 200);
[saltX, saltY] = salter(x, y, 50);
[smoothX, smoothY] = smoother(saltX, saltY, 3);
displayGraph(x, y, 'nLogNGraph');
displayGraph(saltX, saltY, 'salted');
displayGraph(smoothX, smoothY, 'smoothed');

