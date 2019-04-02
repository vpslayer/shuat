# tag: graph, dfs search

graph = {'A': set(['B', 'C']),
         'B': set(['A', 'D', 'E']),
         'C': set(['A', 'F']),
         'D': set(['B']),
         'E': set(['B', 'F']),
         'F': set(['C', 'E'])}

# iterative way

def dfs1(graph, start):
    visited, stack = set(), [start]
    while stack:
        node = stack.pop()
        if node not in visited:
            visited.add(node)
            stack.extend(graph[node] - visited)
    return visited

#recursive way

def dfs2(graph, start, visited=None):
    if visited == None:
        visited = set()
    visited.add(start)  # update visited in every recurrsion
    for node in graph[start] - visited:
        dfs2(graph, node, visited)
    return visited



print(dfs2(graph, 'A'))