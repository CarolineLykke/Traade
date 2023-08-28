package dk.cphbusiness.e23.sem2.threads.producerconsumer;

public class SingleSynchronizedBuffer<ProductType> implements ISyncBuffer<ProductType>
{
	private ProductType product;
	private Object teddyBear;

	public SingleSynchronizedBuffer()
	{
		product = null;
		teddyBear = new Object();
	}

	public void addProduct(ProductType product)
	{
		synchronized (teddyBear)
		{
			while (this.product != null)
			{
				try
				{
					teddyBear.wait(); //This releases the lock on teddyBear
				} catch (InterruptedException e)
				{
				}
			}
			this.product = product;
			teddyBear.notifyAll();
		} //This releases the lock on teddyBear
	}

	public ProductType getProduct()
	{
		synchronized (teddyBear)
		{
			while (product == null)
			{
				try
				{
					teddyBear.wait(); //This releases the lock on teddyBear
				} catch (InterruptedException e)
				{
				}
			}
			ProductType temp = product;
			product = null;
			teddyBear.notifyAll();
			return temp;
		} //This releases the lock on teddyBear
	}
}
