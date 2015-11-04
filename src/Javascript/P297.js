function TreeNode(val){
	this.val = val; 
	this.left = this.right = null; 
}
/**
 * Encodes a tree to a single string.
 *
 * @param {TreeNode} root
 * @return {string}
 */
var serialize = function(root) {
    var out = [];
    var que = [];
    que.push(root);
    while (que.length>0){
        var node = que.shift();
        if (node!==null){
            que.push(node.left);
            que.push(node.right);
            out.push(node.val);
        }else {
            out.push(null);
        }
    }
    return out;
};

/**
 * Decodes your encoded data to tree.
 *
 * @param {string} data
 * @return {TreeNode}
 */
var deserialize = function(data) {
    var que = [];
    var root=null;
    if (data.length>0&&data[0]!==null) root = new TreeNode(data.shift());
    else return root;
    que.push(root);
    while (que.length>0){
        var node = que.shift();
        if (data.length<=0) break;
        var lval = data.shift();
        if (lval!==null) {
            node.left = new TreeNode(lval);
            que.push(node.left);
        }
        if (data.length<=0) break;
        var rval = data.shift();
        if (rval!==null){
            node.right = new TreeNode(rval);
            que.push(node.right);
        }
    }
    return root;
};

/**
 * Your functions will be called as such:
 * deserialize(serialize(root));
 */
