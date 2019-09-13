**DFS & DP**

* Top-down DFS
在helper内部最后某个停止条件的时候判断并且return

* Bottom-up DFS
helper内部停止条件时不判断，在外层判断，停止条件return 0

> Botton-up DFS ---> + memo ---> DP

套路如下：
例题：[1066. Campus Bike II](https://github.com/ZoeZhengYQ/LeetCode_solution/blob/master/medium/1066_campus_bikes_II.java)

**Top-down**

```
public int main(...) {
	dfs(...)
}

private void dfs(...) {
	if (reach stop bound) {
		process result;
		return;
	}

	// Do something with current status
	// dfs(...) for next status
}
```


**Bottom-up**

```
public int main(...) {
	dfs(...)
}

private void dfs(...) {
	if (reach stop bound) {
		return 0;
	}

	for (choices) {
		// collect results from other dependent status
		// Process the results
	}
}
```


