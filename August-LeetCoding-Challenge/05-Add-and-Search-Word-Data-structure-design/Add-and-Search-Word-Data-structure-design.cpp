#define ALPHABET_SIZE 26
class Trie {
public:
	bool isEnd;
	unique_ptr<Trie> links[ALPHABET_SIZE];
	/** Initialize your data structure here. */
	Trie() {
		this->isEnd = false;
	}

	bool containsChar(char ch) {
		return links[ch - 'a'] != nullptr;
	}
	void put(char ch, Trie* newt) {
		links[ch - 'a'].reset(newt);
	}

	Trie* get(char ch) {
		return links[ch - 'a'].get();
	}

	/** Inserts a word into the trie. */
	void insert(string word) {
		// start from root node
		Trie* root = this;
		for (int i = 0; i < word.length(); i++) {
			// create a new node if path doesn't exists
			if (!root->containsChar(word[i])) {
				root->put(word[i], new Trie());
			}
			root = root->get(word[i]);
		}
		// make current node as a keyword
		root->isEnd = true;
	}

	/** Returns if the word is in the trie. */
	bool search(string word) {
		if (this == nullptr)
			return false;
		Trie* root = this;
		for (int i = 0; i < word.length(); i++) {
			root = root->get(word[i]);
			if (root == nullptr)
				return false;
		}
		return root->isEnd;
	}

	/** Returns if there is any word in the trie that starts with the given prefix. */
	bool startsWith(string prefix) {
		if (this == nullptr)
			return false;
		Trie* root = this;
		int i = 0;
		for (; i < prefix.length(); i++) {
			root = root->get(prefix[i]);
			if (root == nullptr)
				return false;
		}
		return i == prefix.length();
	}

	~Trie(){}
};

class WordDictionary {
public:
	unique_ptr<Trie> t;
	/** Initialize your data structure here. */
	WordDictionary() {
		t.reset(new Trie());
	}

	/** Adds a word into the data structure. */
	void addWord(string word) {
		t->insert(word);
	}

	/** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
	bool search(string word) {
		return searchUtil(t.get(), word, 0);
	}

	bool searchUtil(Trie* t, const string& word, int index) {
		if (!t)
			return false;
		if (index == word.length())
			return t->isEnd;
		char c = word[index];
		if (c == '.') {
			for (int i = 0; i < ALPHABET_SIZE; i++) {
				if (searchUtil(t->get('a' + i), word, index + 1))
					return true;
			}
		}
		else {
			return searchUtil(t->get(c), word, index + 1);
		}
		return false;
	}

	~WordDictionary(){}
};


/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary* obj = new WordDictionary();
 * obj->addWord(word);
 * bool param_2 = obj->search(word);
 */
