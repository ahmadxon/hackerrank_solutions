#include <assert.h>
#include <limits.h>
#include <math.h>
#include <stdbool.h>
#include <stddef.h>
#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* readline();

int main(){
    int h; 
    scanf("%d",&h);
    int m; 
    scanf("%d",&m);

    char *hours[] = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve"};

    char *minutes[] = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", 
                       	   "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "ninteen", "twenty",
                           "twenty one", "twenty two", "twenty three", "twenty four", "twenty five", "twenty six", "twenty seven", "twenty eight", "twenty nine"};

    char *hour;

    if (m == 0) {
        hour = hours[h - 1];
        printf("%s o' clock", hour);
    }
    else if (m == 1) {
        hour = hours[h - 1];
        printf("one minute past %s", hour);
    }
    else if (m == 10) {
        hour = hours[h - 1];
        printf("ten minutes past %s", hour);
    }
    else if (m == 15) {
        hour = hours[h - 1];
        printf("quarter past %s", hour);
    }
    else if (m == 30) {
        hour = hours[h - 1];
        printf("half past %s", hour);
    }
    else if (m == 40) {
        hour = hours[h];
        printf("twenty minutes to %s", hour);
    }
    else if (m == 45) {
        hour = hours[h];
        printf("quarter to %s", hour);
    }
    else if (m < 30) {
        hour = hours[h - 1];
        printf("%s minutes past %s", minutes[m - 1], hour);
    }
    else if (m > 30) {
        hour = hours[h];
        printf("%s minutes to %s", minutes[60 - m - 1], hour);
    }

    return 0;
}

char* readline() {
    size_t alloc_length = 1024;
    size_t data_length = 0;
    char* data = malloc(alloc_length);

    while (true) {
        char* cursor = data + data_length;
        char* line = fgets(cursor, alloc_length - data_length, stdin);

        if (!line) { break; }

        data_length += strlen(cursor);

        if (data_length < alloc_length - 1 || data[data_length - 1] == '\n') { break; }

        size_t new_length = alloc_length << 1;
        data = realloc(data, new_length);

        if (!data) { break; }

        alloc_length = new_length;
    }

    if (data[data_length - 1] == '\n') {
        data[data_length - 1] = '\0';
    }

    data = realloc(data, data_length);

    return data;
}