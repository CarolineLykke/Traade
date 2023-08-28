package dk.cphbusiness.e23.sem2.threads.producerconsumer;

public class MultiSynchronizedBuffer <ProductType> implements ISyncBuffer<ProductType>{
    private ProductType[] buffer;
    private int size;
    private Object teddyBear;


    public MultiSynchronizedBuffer() {
        this.buffer = (ProductType[]) new Object[100]; // Initialiser med kapacitet på 100
        this.size = 0;
        this.teddyBear = new Object();
    }

    public void addProduct(ProductType product)
    {
        synchronized (teddyBear)
        {
            while (size == buffer.length)
            {
                try
                {
                    teddyBear.wait(); //This releases the lock on teddyBear
                } catch (InterruptedException e)
                {
                }
            }
            buffer[size++] = product;
            teddyBear.notifyAll();
        } //This releases the lock on teddyBear
    }

    public ProductType getProduct()
    {
        synchronized (teddyBear)
        {
            while (size == 0)
            {
                try
                {
                    teddyBear.wait(); //This releases the lock on teddyBear
                } catch (InterruptedException e)
                {
                }
            }
            ProductType temp = buffer[--size];
            buffer[size] = null;
            teddyBear.notifyAll();
            return temp;
        } //This releases the lock on teddyBear
    }

}
