function [smoothX, smoothY] = smoother (x, y, range)

      if (isnumeric(range))
        tmp = range/2;
        tmp = round(tmp);
        tmp++;
      else
        error ('argument range is non numeric')
      endif

      if (ismatrix(x) && ismatrix(y))
        smoothX = [];
        smoothY = [];
        pos = 1;
        j = 1;
        avgX = 0;
        avgY = 0;
        for i = 1:numel(x)
          if (j == tmp)
            avgX = avgX / tmp;
            avgY = avgY / tmp;
            smoothX(pos) = avgX;
            smoothY(pos) = avgY;

            pos++;
            avgX = 0;
            avgY = 0;
            j = 0;
          else
            avgX += x(i);
            avgY += y(i);
            j++;

          endif
        endfor
      else
        error ('argument x or y is not a matrix');
      endif
    endfunction
