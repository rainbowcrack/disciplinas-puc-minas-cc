int x = 0;
for(int i = 15; i < n; i++){
    for(int j = 0; j < 3; j++) x += a * 2;
    for(int k = i; k < n; k++){
        x += b * 5;
        x += x * 10;
    }
    x += c * 4;
}