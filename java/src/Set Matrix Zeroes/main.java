package Set Matrix Zeroes;

    class main{
        public void setZeroes(int[][] matrix) {
            for(int i = 0; i< matrix.length;i++){
                for(int j = 0; j< matrix[i].length;j++){
                    if(matrix[i][j] == 0)matrix[i][j] = Integer.MAX_VALUE-1;
                }
            }
            for(int i = 0; i < matrix.length; i++){
                for(int j = 0; j < matrix[i].length; j++){
                    if(matrix[i][j] == Integer.MAX_VALUE-1){
                        for(int v = 0; v< matrix.length;v++){
                            if(matrix[v][j]!= Integer.MAX_VALUE-1){
                                matrix[v][j] = 0;
                            }
                        }
                        for(int v = 0; v< matrix[i].length;v++){
                            if(matrix[i][v]!= Integer.MAX_VALUE-1){
                                matrix[i][v] = 0;
                            }
                        }
                    }
                }
            }
            for(int i = 0; i < matrix.length; i++){
                for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == Integer.MAX_VALUE-1)matrix[i][j] = 0;
                }
            }

        }
    }
