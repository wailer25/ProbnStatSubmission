function displayGraph (x, y, name)

      if (ismatrix(x) && ismatrix(y))
        figure;
        plot(x, y);
      else
        error ('argument x or y is not a matrix');
      endif

      if (is_sq_string(name) || is_dq_string(name))
        title(name);
      else
        error ('title is not a string');
      endif
      xlabel('Variable x');
      ylabel('Variable y');
      set(gca, 'fontsize', 22);
    endfunction
