//#include "stdafx.h"
#include <iostream>
using namespace std;

int fact(int n)
{
	if (n == 1) {
		return n;
	}
	else {
		n = n * fact(n - 1);
	}
}

int main() 
{
	int num = 0;
	int factfor = 1;
	cin >> num;

	for (int i = num; i >= 1; i--)
	{
		factfor = factfor * i;
	}
	cout << factfor << "\n";
	cout << fact(num);

	return 0;
}