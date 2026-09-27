int[] warm = rnd.ints(5_000).toArray();
        for (int i = 0; i < 5; i++) { 
            linear(warm); 
            quadratic(warm); 
            nLogN(warm); }