class Solution {
public:
    // using nth_element
    /*
    int findKthLargest(vector<int>& nums, int k) {
        nth_element(nums.begin(), nums.begin() + k - 1, nums.end(), greater<int> ());
        return nums[k - 1];
    }
    */
    
    // implement nth element using quicksort
    
    int findKthLargest(vector<int>& nums, int k) {
        int left = 0;
        int right = nums.size() - 1;
        while (true) {
            int par = partition(nums, left, right);
            if (par == k - 1) {
                return nums[par];
            }
            if (par < k - 1) {
                left = par + 1;
            }
            else {
                right = par - 1;
            }
        }
    }
    
    int partition(vector<int> &nums, int left, int right) {
        int p = left;
        left++;
        int pivot = nums[p];
        while (left <= right) {
            if (nums[left] < pivot && nums[right] > pivot) {
                swap(nums[left++], nums[right--]);
            }
            if (nums[left] >= pivot) { left++; }
            if (nums[right] <= pivot) { right--; }
        }
        swap(nums[p], nums[right]);
        return right;
    }
    
    
    // solution using heapsort
    /*
    int findKthLargest(vector<int>& nums, int k) {
        build_max_heap(nums);
        for (int i = 0; i < k - 1; i++) {
            swap(nums[0], nums[heap_size - 1]);
            heap_size--;
            max_heapify(nums, 0);
        }
        return nums[0];
    }
private:
    int heap_size;
    
    // find left child
    inline int left(int idx) {
        return (idx << 1) + 1;
    }
    
    // find right child
    inline int right(int idx) {
        return (idx << 1) + 2;
    }
    
    void max_heapify(vector<int>& nums, int idx) {
        int largest = idx, l = left(idx), r = right(idx);
        if (l < heap_size && nums[l] > nums[largest]) {
            largest = l;
        }
        if (r < heap_size && nums[r] > nums[largest]) {
            largest = r;
        }
        if (largest != idx) {
            swap(nums[idx], nums[largest]);
            max_heapify(nums, largest);
        }
    }
    
    void build_max_heap(vector<int>& nums) {
        heap_size = nums.size();
        // find parent
        for (int i = (heap_size >> 1) - 1; i >= 0; i--) {
            max_heapify(nums, i);
        }
    }
    */
};