## **Challenge 3** - Board games

You can't lie to us, we know you love board games... you absolutely love them, and we also know that you are tired of the typical point counting method.

We need a cool system for counting points for our brand new board game, and we think we could use cards to do it. For example, a score of 10 could be represented with the set of cards 7 and 3\. But those fancy printed cards don't come cheap and that's why we need you!

We want to know how many cards we need to print, given a maximum possible score. We don't want our board game to have repeated cards, so you need to tell us the size of the smallest set of cards that, for any number from 1 to P, we can find a subset of those cards whose sum equals that number, being P the maximum score of the game.

### Input

The first line will contain an integer **C**, the number of cases for our problem.  
Each case consists of a line with the integer **P**, the maximum points you need to be able to count.

### Output

For each case, a line starting with "Case #x: " followed by the size of the minimum set of cards needed for the score **P**.

### Examples

<table style="width:100%">

<tbody>

<tr>

<td>

<pre>Case 1:

1
</pre>

</td>

<td>

<pre>Case 2:

6
</pre>

</td>

<td>

<pre>Case 3:

3
</pre>

</td>

</tr>

</tbody>

</table>

In Case 1, we need a card with 1.  
In Case 2, we can count up to 6 with only 3 cards, for example 1, 2 and 3.  
In Case 3, we need the cards 1 and 2.

### Limits

*   1 ≤ **C** ≤ 10<sup>4</sup>
*   1 ≤ **P** ≤ 10<sup>9</sup>

### Sample Input

<pre>
3
1
6
3
</pre>

### Sample Output

<pre>
Case #1: 1
Case #2: 3
Case #3: 2
</pre>

</div>