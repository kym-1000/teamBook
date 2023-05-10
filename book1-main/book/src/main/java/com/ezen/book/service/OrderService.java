package com.ezen.book.service;

import java.util.List;

import com.ezen.book.domain.DeliveryDTO;
import com.ezen.book.domain.FileVO;
import com.ezen.book.domain.OrderDTO;
import com.ezen.book.domain.OrderItemDTO;
import com.ezen.book.domain.OrderPageItemDTO;
import com.ezen.book.domain.OrderVO;
import com.ezen.book.domain.PagingVO;

public interface OrderService {

   List<OrderVO> getList(PagingVO pvo, String status, int mem_num);



   int getOrderTotalCount(int mem_num);

   int getBuyTotalCount(int mem_num);
   
   public List<OrderPageItemDTO> getGoodsInfo(List<OrderPageItemDTO> orders);

  	public void order(OrderDTO od);

  	public List<OrderDTO> getOrderList(int order_mem_num);

  	public List<OrderItemDTO> orderDetail(String order_num);



	List<FileVO> selectFileList(int cart_book_num);



	void Confirmed(String order_num);



	void setDelivery(DeliveryDTO ddto);

}