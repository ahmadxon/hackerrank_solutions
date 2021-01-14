using System;
using System.IO;
using System.Text;
class Solution
{
    static void Main(String[] args)
    {
        var inputKeysCount = int.Parse(Console.ReadLine());
        var keyFrequency = new int[100];
        var inputArray = new Data[inputKeysCount];
        for (var i = 0; i < inputKeysCount; i++)
        {
            var tokens = Console.ReadLine().Split(' ');
            var key = int.Parse(tokens[0]);
            var text = tokens[1];
            if (i + 1 <= inputKeysCount / 2)
                text = "-";
            inputArray[i] = new Data { Key = key, Value = text };
            keyFrequency[key] += 1;
        }
        for (var i = 1; i < 100; i++)
            keyFrequency[i] += keyFrequency[i - 1];

        var sortedOutput = new Data[inputKeysCount];

        for (var i = inputKeysCount - 1; i >= 0; i--)
        {
            var key = inputArray[i].Key;
            var position = keyFrequency[key];
            keyFrequency[key] -= 1;
            sortedOutput[position - 1] = inputArray[i];
        }
        var stringBuilder = new StringBuilder();
        for (var i = 0; i < inputKeysCount; i++)
            stringBuilder.Append(sortedOutput[i].Value + ' ');
        Console.Write(stringBuilder.ToString());
    }
}

public class Data
{
    public int Key { get; set; }
    public string Value { get; set; }
}