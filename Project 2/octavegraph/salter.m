function [saltX, saltY] = salter (x, y, saltBounds)
      if (ismatrix(x) && ismatrix(y))
        saltX = x;
        saltY = [];
        if (isnumeric(saltBounds))
          for i = 1:numel(x)
            operand = randi(2);
            if(operand > 1)
              saltY(i) = y(i) + randi(saltBounds);
            else
              saltY(i) = y(i) - randi(saltBounds);
            endif
          endfor
        else
          error ('argument saltbounds is non numeric');
        endif
      else
        error ('argument x or y is not a matrix');
      endif
    endfunction
