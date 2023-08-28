package dk.cphbusiness.e23.sem2.threads.producerconsumer;

public interface ISyncBuffer<ProductType>
{
	void addProduct(ProductType product);
	ProductType getProduct();
}
