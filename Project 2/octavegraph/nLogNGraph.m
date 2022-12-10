function [x, y] = nLogNGraph(n, graphSize)
      if (isnumeric(n) && isnumeric(graphSize))
        x = 1:n:n*graphSize;
        y = [];
        for i = 1:numel(x)
          y(i) = x(i) * log10(x(i));
        endfor
      else
        error ('argument is non numeric');
      endif
    endfunction
