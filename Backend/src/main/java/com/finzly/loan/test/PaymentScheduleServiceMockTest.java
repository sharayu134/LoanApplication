package com.finzly.loan.test;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
//import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.finzly.loan.dao.PaymentScheduleRepository;
import com.finzly.loan.model.Loan;
import com.finzly.loan.model.PaymentSchedule;
import com.finzly.loan.service.PaymentScheduleService;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

class PaymentScheduleServiceMockTest {
		
	@org.junit.jupiter.api.Test
	void testfor_PrincipleType_InterestOnly_Frequency_HalfYearly() {
		
		PaymentScheduleRepository paymentScheduleRepository = mock(PaymentScheduleRepository.class);
		PaymentSchedule mockPaymentSchedule =new PaymentSchedule(0,LocalDate.of(2021,5,12),0,180,"projected",180);
		mockPaymentSchedule.setPaymentScheduleId(0);
		when(paymentScheduleRepository.save(any(PaymentSchedule.class))).thenReturn(mockPaymentSchedule);
		
		Loan loan = new Loan(10001,3600,LocalDate.of(2020,11,12),LocalDate.of(2020, 11, 12),LocalDate.of(2021, 11, 12),2,10,1,"interestOnly");
		PaymentScheduleService paymentScheduleService=new PaymentScheduleService(paymentScheduleRepository);
		List<PaymentSchedule>acualPaymentScheduleList =paymentScheduleService.save(loan);
		 
		List<PaymentSchedule>expectedPaymentScheduleList = new ArrayList<PaymentSchedule>(); 
		PaymentSchedule paymentSchedule = new PaymentSchedule(0,LocalDate.of(2021,5,12),0,180,"projected",180);
		expectedPaymentScheduleList.add(paymentSchedule);
		paymentSchedule = new PaymentSchedule(0,LocalDate.of(2021,11,12),3600,180,"projected",3780);	
		expectedPaymentScheduleList.add(paymentSchedule);
		
		assertIterableEquals(expectedPaymentScheduleList, acualPaymentScheduleList);
	}
	
	@org.junit.jupiter.api.Test
	void testfor_PrincipleType_EvenFrequency_HalfYearly() {
		PaymentScheduleRepository paymentScheduleRepository = mock(PaymentScheduleRepository.class);
		PaymentSchedule mockPaymentSchedule =new PaymentSchedule(0,LocalDate.of(2021,5,12),0,180,"projected",180);
		mockPaymentSchedule.setPaymentScheduleId(0);
		when(paymentScheduleRepository.save(any(PaymentSchedule.class))).thenReturn(mockPaymentSchedule);
		
		PaymentScheduleService paymentScheduleService=new PaymentScheduleService(paymentScheduleRepository);
		Loan loan = new Loan(10001,3600,LocalDate.of(2020,11,12),LocalDate.of(2020, 11, 12),LocalDate.of(2021, 11, 12),2,10,1,"even");
		List<PaymentSchedule>acualPaymentScheduleList =paymentScheduleService.save(loan);
		
		List<PaymentSchedule>expectedPaymentScheduleList = new ArrayList<PaymentSchedule>(); 
		PaymentSchedule paymentSchedule = new PaymentSchedule(0,LocalDate.of(2021,5,12),1800,180,"projected",1980);
		expectedPaymentScheduleList.add(paymentSchedule);
		paymentSchedule = new PaymentSchedule(0,LocalDate.of(2021,11,12),1800,90,"projected",1890);	
		expectedPaymentScheduleList.add(paymentSchedule);

		assertIterableEquals(expectedPaymentScheduleList, acualPaymentScheduleList);
	}
	
	@org.junit.jupiter.api.Test
	void testfor_PrincipleType_Even_Frequency_Yearly() {
		PaymentScheduleRepository paymentScheduleRepository = mock(PaymentScheduleRepository.class);
		PaymentSchedule mockPaymentSchedule =new PaymentSchedule(0,LocalDate.of(2021,5,12),0,180,"projected",180);
		mockPaymentSchedule.setPaymentScheduleId(0);
		when(paymentScheduleRepository.save(any(PaymentSchedule.class))).thenReturn(mockPaymentSchedule);
		
		PaymentScheduleService paymentScheduleService=new PaymentScheduleService(paymentScheduleRepository);
		Loan loan = new Loan(10001,3600,LocalDate.of(2020,11,12),LocalDate.of(2020, 11, 12),LocalDate.of(2021, 11, 12),1,10,1,"even");
		List<PaymentSchedule>acualPaymentScheduleList =paymentScheduleService.save(loan);
		
		List<PaymentSchedule>expectedPaymentScheduleList = new ArrayList<PaymentSchedule>(); 
		PaymentSchedule paymentSchedule = new PaymentSchedule(0,LocalDate.of(2021,11,12),3600,360,"projected",3960);
		expectedPaymentScheduleList.add(paymentSchedule);

		assertIterableEquals(expectedPaymentScheduleList, acualPaymentScheduleList);
	}

	@org.junit.jupiter.api.Test
	void testfor_PrincipleType_InterestOnly_Frequency_Yearly() {
		PaymentScheduleRepository paymentScheduleRepository = mock(PaymentScheduleRepository.class);
		PaymentSchedule mockPaymentSchedule =new PaymentSchedule(0,LocalDate.of(2021,5,12),0,180,"projected",180);
		mockPaymentSchedule.setPaymentScheduleId(0);
		when(paymentScheduleRepository.save(any(PaymentSchedule.class))).thenReturn(mockPaymentSchedule);
		
		PaymentScheduleService paymentScheduleService=new PaymentScheduleService(paymentScheduleRepository);
		Loan loan = new Loan(10001,3600,LocalDate.of(2020,11,12),LocalDate.of(2020, 11, 12),LocalDate.of(2021, 11, 12),1,10,1,"interestOnly");
		List<PaymentSchedule>acualPaymentScheduleList =paymentScheduleService.save(loan);
		
		List<PaymentSchedule>expectedPaymentScheduleList = new ArrayList<PaymentSchedule>(); 
		PaymentSchedule paymentSchedule = new PaymentSchedule(0,LocalDate.of(2021,11,12),3600,360,"projected",3960);
		expectedPaymentScheduleList.add(paymentSchedule);

		assertIterableEquals(expectedPaymentScheduleList, acualPaymentScheduleList);
	}
	@org.junit.jupiter.api.Test
	void testfor_PrincipleType_Even_Frequency_Quarterly() {
		PaymentScheduleRepository paymentScheduleRepository = mock(PaymentScheduleRepository.class);
		PaymentSchedule mockPaymentSchedule =new PaymentSchedule(0,LocalDate.of(2021,5,12),0,180,"projected",180);
		mockPaymentSchedule.setPaymentScheduleId(0);
		when(paymentScheduleRepository.save(any(PaymentSchedule.class))).thenReturn(mockPaymentSchedule);
		
		PaymentScheduleService paymentScheduleService=new PaymentScheduleService(paymentScheduleRepository);
		Loan loan = new Loan(10001,3600,LocalDate.of(2020,11,12),LocalDate.of(2020, 11, 12),LocalDate.of(2021, 11, 12),4,10,1,"even");
		List<PaymentSchedule>acualPaymentScheduleList =paymentScheduleService.save(loan);
		List<PaymentSchedule>expectedPaymentScheduleList = new ArrayList<PaymentSchedule>(); 
		
		PaymentSchedule paymentSchedule = new PaymentSchedule(0,LocalDate.of(2021,2,12),900,90,"projected",990);
		expectedPaymentScheduleList.add(paymentSchedule);
	    paymentSchedule = new PaymentSchedule(0,LocalDate.of(2021,5,12),900,67.5,"projected",967.5);
		expectedPaymentScheduleList.add(paymentSchedule);
		paymentSchedule = new PaymentSchedule(0,LocalDate.of(2021,8,12),900,45,"projected",945);
		expectedPaymentScheduleList.add(paymentSchedule);
		paymentSchedule = new PaymentSchedule(0,LocalDate.of(2021,11,12),900,22.5,"projected",922.5);
		expectedPaymentScheduleList.add(paymentSchedule);

		assertIterableEquals(expectedPaymentScheduleList, acualPaymentScheduleList);
	}
	
	@org.junit.jupiter.api.Test
	void testfor_PrincipleType_InterestOnly_Frequency_Quarterly() {
		PaymentScheduleRepository paymentScheduleRepository = mock(PaymentScheduleRepository.class);
		PaymentSchedule mockPaymentSchedule =new PaymentSchedule(0,LocalDate.of(2021,5,12),0,180,"projected",180);
		mockPaymentSchedule.setPaymentScheduleId(0);
		when(paymentScheduleRepository.save(any(PaymentSchedule.class))).thenReturn(mockPaymentSchedule);
		
		PaymentScheduleService paymentScheduleService=new PaymentScheduleService(paymentScheduleRepository);
		Loan loan = new Loan(10001,3600,LocalDate.of(2020,11,12),LocalDate.of(2020, 11, 12),LocalDate.of(2021, 11, 12),4,10,1,"interestOnly");
		List<PaymentSchedule>acualPaymentScheduleList =paymentScheduleService.save(loan);
		
		List<PaymentSchedule>expectedPaymentScheduleList = new ArrayList<PaymentSchedule>(); 
		PaymentSchedule paymentSchedule = new PaymentSchedule(0,LocalDate.of(2021,2,12),0,90,"projected",90);
		expectedPaymentScheduleList.add(paymentSchedule);
	    paymentSchedule = new PaymentSchedule(0,LocalDate.of(2021,5,12),0,90,"projected",90);
		expectedPaymentScheduleList.add(paymentSchedule);
		paymentSchedule = new PaymentSchedule(0,LocalDate.of(2021,8,12),0,90,"projected",90);
		expectedPaymentScheduleList.add(paymentSchedule);
		paymentSchedule = new PaymentSchedule(0,LocalDate.of(2021,11,12),3600,90,"projected",3690);
		expectedPaymentScheduleList.add(paymentSchedule);

		assertIterableEquals(expectedPaymentScheduleList, acualPaymentScheduleList);
	}
	
	@org.junit.jupiter.api.Test
	void testfor_PrincipleType_Even_Frequency_Monthly() {
		
		PaymentScheduleRepository paymentScheduleRepository = mock(PaymentScheduleRepository.class);
		PaymentSchedule mockPaymentSchedule =new PaymentSchedule(0,LocalDate.of(2021,5,12),0,180,"projected",180);
		mockPaymentSchedule.setPaymentScheduleId(0);
		when(paymentScheduleRepository.save(any(PaymentSchedule.class))).thenReturn(mockPaymentSchedule);
		
		PaymentScheduleService paymentScheduleService=new PaymentScheduleService(paymentScheduleRepository);
		Loan loan = new Loan(10001,3600,LocalDate.of(2020,11,12),LocalDate.of(2020, 11, 12),LocalDate.of(2021, 11, 12),12,10,1,"even");
		List<PaymentSchedule>acualPaymentScheduleList =paymentScheduleService.save(loan);
		List<PaymentSchedule>expectedPaymentScheduleList = new ArrayList<PaymentSchedule>(); 
		
		PaymentSchedule paymentSchedule = new PaymentSchedule(0,LocalDate.of(2020,12,12),300,30,"projected",330);
		expectedPaymentScheduleList.add(paymentSchedule);
	    paymentSchedule = new PaymentSchedule(0,LocalDate.of(2021,1,12),300,27.5,"projected",327.5);
		expectedPaymentScheduleList.add(paymentSchedule);
		paymentSchedule = new PaymentSchedule(0,LocalDate.of(2021,2,12),300,25,"projected",325);
		expectedPaymentScheduleList.add(paymentSchedule);
		paymentSchedule = new PaymentSchedule(0,LocalDate.of(2021,3,12),300,22.5,"projected",322.5);
		expectedPaymentScheduleList.add(paymentSchedule);
	    paymentSchedule = new PaymentSchedule(0,LocalDate.of(2021,4,12),300,20,"projected",320);
	    expectedPaymentScheduleList.add(paymentSchedule);
	    paymentSchedule = new PaymentSchedule(0,LocalDate.of(2021,5,12),300,17.5,"projected",317.5);
	    expectedPaymentScheduleList.add(paymentSchedule);
	    paymentSchedule = new PaymentSchedule(0,LocalDate.of(2021,6,12),300,15,"projected",315);
	    expectedPaymentScheduleList.add(paymentSchedule);
	    paymentSchedule = new PaymentSchedule(0,LocalDate.of(2021,7,12),300,12.5,"projected",312.5);
	    expectedPaymentScheduleList.add(paymentSchedule);
	    paymentSchedule = new PaymentSchedule(0,LocalDate.of(2021,8,12),300,10,"projected",310);
	    expectedPaymentScheduleList.add(paymentSchedule);
	    paymentSchedule = new PaymentSchedule(0,LocalDate.of(2021,9,12),300,7.5,"projected",307.5);
	    expectedPaymentScheduleList.add(paymentSchedule);
	    paymentSchedule = new PaymentSchedule(0,LocalDate.of(2021,10,12),300,5,"projected",305);
	    expectedPaymentScheduleList.add(paymentSchedule);
	    paymentSchedule = new PaymentSchedule(0,LocalDate.of(2021,11,12),300,2.5,"projected",302.5);
	    expectedPaymentScheduleList.add(paymentSchedule);

		assertIterableEquals(expectedPaymentScheduleList, acualPaymentScheduleList);
	}
	
	@org.junit.jupiter.api.Test
	void testfor_PrincipleType_InterestOnly_Frequency_Monthly() {
		PaymentScheduleRepository paymentScheduleRepository = mock(PaymentScheduleRepository.class);
		PaymentSchedule mockPaymentSchedule =new PaymentSchedule(0,LocalDate.of(2021,5,12),0,180,"projected",180);
		mockPaymentSchedule.setPaymentScheduleId(0);
		when(paymentScheduleRepository.save(any(PaymentSchedule.class))).thenReturn(mockPaymentSchedule);
		
		PaymentScheduleService paymentScheduleService=new PaymentScheduleService(paymentScheduleRepository);
		Loan loan = new Loan(10001,3600,LocalDate.of(2020,11,12),LocalDate.of(2020, 11, 12),LocalDate.of(2021, 11, 12),12,10,1,"interestOnly");
		List<PaymentSchedule>acualPaymentScheduleList =paymentScheduleService.save(loan);
		List<PaymentSchedule>expectedPaymentScheduleList = new ArrayList<PaymentSchedule>(); 
		
		PaymentSchedule paymentSchedule = new PaymentSchedule(0,LocalDate.of(2020,12,12),0,30,"projected",30);
		expectedPaymentScheduleList.add(paymentSchedule);
	    paymentSchedule = new PaymentSchedule(0,LocalDate.of(2021,1,12),0,30,"projected",30);
		expectedPaymentScheduleList.add(paymentSchedule);
		paymentSchedule = new PaymentSchedule(0,LocalDate.of(2021,2,12),0,30,"projected",30);
		expectedPaymentScheduleList.add(paymentSchedule);
		paymentSchedule = new PaymentSchedule(0,LocalDate.of(2021,3,12),0,30,"projected",30);
		expectedPaymentScheduleList.add(paymentSchedule);
	    paymentSchedule = new PaymentSchedule(0,LocalDate.of(2021,4,12),0,30,"projected",30);
	    expectedPaymentScheduleList.add(paymentSchedule);
	    paymentSchedule = new PaymentSchedule(0,LocalDate.of(2021,5,12),0,30,"projected",30);
	    expectedPaymentScheduleList.add(paymentSchedule);
	    paymentSchedule = new PaymentSchedule(0,LocalDate.of(2021,6,12),0,30,"projected",30);
	    expectedPaymentScheduleList.add(paymentSchedule);
	    paymentSchedule = new PaymentSchedule(0,LocalDate.of(2021,7,12),0,30,"projected",30);
	    expectedPaymentScheduleList.add(paymentSchedule);
	    paymentSchedule = new PaymentSchedule(0,LocalDate.of(2021,8,12),0,30,"projected",30);
	    expectedPaymentScheduleList.add(paymentSchedule);
	    paymentSchedule = new PaymentSchedule(0,LocalDate.of(2021,9,12),0,30,"projected",30);
	    expectedPaymentScheduleList.add(paymentSchedule);
	    paymentSchedule = new PaymentSchedule(0,LocalDate.of(2021,10,12),0,30,"projected",30);
	    expectedPaymentScheduleList.add(paymentSchedule);
	    paymentSchedule = new PaymentSchedule(0,LocalDate.of(2021,11,12),3600,30,"projected",3630);
	    expectedPaymentScheduleList.add(paymentSchedule);

		assertIterableEquals(expectedPaymentScheduleList, acualPaymentScheduleList);
	}
	
	@org.junit.jupiter.api.Test
	void testfor_PrincipleType_InterestOnly_Frequency_Monthly_With_DifferentStartDate() {
		
		PaymentScheduleRepository paymentScheduleRepository = mock(PaymentScheduleRepository.class);
		PaymentSchedule mockPaymentSchedule =new PaymentSchedule(0,LocalDate.of(2021,5,12),0,180,"projected",180);
		mockPaymentSchedule.setPaymentScheduleId(0);
		when(paymentScheduleRepository.save(any(PaymentSchedule.class))).thenReturn(mockPaymentSchedule);
		
		PaymentScheduleService paymentScheduleService=new PaymentScheduleService(paymentScheduleRepository);
		
		Loan loan = new Loan(10001,3600,LocalDate.of(2020,11,2),LocalDate.of(2020, 11, 12),LocalDate.of(2021, 11, 12),12,10,1,"interestOnly");
		List<PaymentSchedule>acualPaymentScheduleList =paymentScheduleService.save(loan);
		List<PaymentSchedule>expectedPaymentScheduleList = new ArrayList<PaymentSchedule>(); 
		
		PaymentSchedule paymentSchedule = new PaymentSchedule(0,LocalDate.of(2020,12,12),0,30,"projected",30);
		expectedPaymentScheduleList.add(paymentSchedule);
	    paymentSchedule = new PaymentSchedule(0,LocalDate.of(2021,1,12),0,30,"projected",30);
		expectedPaymentScheduleList.add(paymentSchedule);
		paymentSchedule = new PaymentSchedule(0,LocalDate.of(2021,2,12),0,30,"projected",30);
		expectedPaymentScheduleList.add(paymentSchedule);
		paymentSchedule = new PaymentSchedule(0,LocalDate.of(2021,3,12),0,30,"projected",30);
		expectedPaymentScheduleList.add(paymentSchedule);
	    paymentSchedule = new PaymentSchedule(0,LocalDate.of(2021,4,12),0,30,"projected",30);
	    expectedPaymentScheduleList.add(paymentSchedule);
	    paymentSchedule = new PaymentSchedule(0,LocalDate.of(2021,5,12),0,30,"projected",30);
	    expectedPaymentScheduleList.add(paymentSchedule);
	    paymentSchedule = new PaymentSchedule(0,LocalDate.of(2021,6,12),0,30,"projected",30);
	    expectedPaymentScheduleList.add(paymentSchedule);
	    paymentSchedule = new PaymentSchedule(0,LocalDate.of(2021,7,12),0,30,"projected",30);
	    expectedPaymentScheduleList.add(paymentSchedule);
	    paymentSchedule = new PaymentSchedule(0,LocalDate.of(2021,8,12),0,30,"projected",30);
	    expectedPaymentScheduleList.add(paymentSchedule);
	    paymentSchedule = new PaymentSchedule(0,LocalDate.of(2021,9,12),0,30,"projected",30);
	    expectedPaymentScheduleList.add(paymentSchedule);
	    paymentSchedule = new PaymentSchedule(0,LocalDate.of(2021,10,12),0,30,"projected",30);
	    expectedPaymentScheduleList.add(paymentSchedule);
	    paymentSchedule = new PaymentSchedule(0,LocalDate.of(2021,11,12),3600,30,"projected",3630);
	    expectedPaymentScheduleList.add(paymentSchedule);

		assertIterableEquals(expectedPaymentScheduleList, acualPaymentScheduleList);
	}
	
	@org.junit.jupiter.api.Test
	void testfor_PrincipleType_InterestOnly_Frequency_Yearly_For_TwoYears() {
		PaymentScheduleRepository paymentScheduleRepository = mock(PaymentScheduleRepository.class);
		PaymentSchedule mockPaymentSchedule =new PaymentSchedule(0,LocalDate.of(2021,5,12),0,180,"projected",180);
		mockPaymentSchedule.setPaymentScheduleId(0);
		when(paymentScheduleRepository.save(any(PaymentSchedule.class))).thenReturn(mockPaymentSchedule);
		
		PaymentScheduleService paymentScheduleService=new PaymentScheduleService(paymentScheduleRepository);
		
		Loan loan = new Loan(10001,3600,LocalDate.of(2020,11,2),LocalDate.of(2020, 11, 12),LocalDate.of(2021, 11, 12),1,10,2,"interestOnly");
		List<PaymentSchedule>acualPaymentScheduleList =paymentScheduleService.save(loan);
		List<PaymentSchedule>expectedPaymentScheduleList = new ArrayList<PaymentSchedule>(); 
		
		PaymentSchedule paymentSchedule = new PaymentSchedule(0,LocalDate.of(2021,11,12),0,360,"projected",360);
		expectedPaymentScheduleList.add(paymentSchedule);
	    paymentSchedule = new PaymentSchedule(0,LocalDate.of(2022,11,12),3600,360,"projected",3960);
		expectedPaymentScheduleList.add(paymentSchedule);
	
		assertIterableEquals(expectedPaymentScheduleList, acualPaymentScheduleList);
	}
	
	@org.junit.jupiter.api.Test
	void testfor_PrincipleType_InterestOnly_Frequency_Yearly_For_ThreeYears() {
		
		PaymentScheduleRepository paymentScheduleRepository = mock(PaymentScheduleRepository.class);
		PaymentSchedule mockPaymentSchedule =new PaymentSchedule(0,LocalDate.of(2021,5,12),0,180,"projected",180);
		mockPaymentSchedule.setPaymentScheduleId(0);
		when(paymentScheduleRepository.save(any(PaymentSchedule.class))).thenReturn(mockPaymentSchedule);
		
		PaymentScheduleService paymentScheduleService=new PaymentScheduleService(paymentScheduleRepository);
		
		Loan loan = new Loan(10001,3600,LocalDate.of(2020,11,2),LocalDate.of(2020, 11, 12),LocalDate.of(2021, 11, 12),1,10,3,"interestOnly");
		List<PaymentSchedule>acualPaymentScheduleList =paymentScheduleService.save(loan);
		List<PaymentSchedule>expectedPaymentScheduleList = new ArrayList<PaymentSchedule>(); 
		
		PaymentSchedule paymentSchedule = new PaymentSchedule(0,LocalDate.of(2021,11,12),0,360,"projected",360);
		expectedPaymentScheduleList.add(paymentSchedule);
	    paymentSchedule = new PaymentSchedule(0,LocalDate.of(2022,11,12),0,360,"projected",360);
		expectedPaymentScheduleList.add(paymentSchedule);
		paymentSchedule = new PaymentSchedule(0,LocalDate.of(2023,11,12),3600,360,"projected",3960);
		expectedPaymentScheduleList.add(paymentSchedule);
	
		assertIterableEquals(expectedPaymentScheduleList, acualPaymentScheduleList);
	}
//	public List<PaymentSchedule> listAll(){
//		return paymentScheduleRepository.findAll();
//	}
	
	@org.junit.jupiter.api.Test
	void testfor_listAll() {
		 Logger logger = LoggerFactory.getLogger(this.getClass());

		
		PaymentScheduleRepository paymentScheduleRepository = mock(PaymentScheduleRepository.class);
		
		List<PaymentSchedule>expectedPaymentScheduleList = new ArrayList<PaymentSchedule>(); 

		PaymentSchedule mockPaymentSchedule =new PaymentSchedule();
		mockPaymentSchedule.setPaymentScheduleId(0);
		mockPaymentSchedule.setLoanId(0);
		mockPaymentSchedule.setPaymentAmount(180);
		mockPaymentSchedule.setPaymentDate(LocalDate.of(2021,5,12));
		mockPaymentSchedule.setPaymentStatus("projected");
		mockPaymentSchedule.setPrincipal(0);
		mockPaymentSchedule.setProjectedInterest(180);
		
		expectedPaymentScheduleList.add(mockPaymentSchedule);
		when(paymentScheduleRepository.findAll()).thenReturn(expectedPaymentScheduleList);
		
		PaymentScheduleService paymentScheduleService=new PaymentScheduleService(paymentScheduleRepository);
		
		List<PaymentSchedule> acualPaymentScheduleList=paymentScheduleService.listAll();
		
		assertIterableEquals(expectedPaymentScheduleList, acualPaymentScheduleList);
		mockPaymentSchedule.getPaymentScheduleId();
		mockPaymentSchedule.getLoanId();
		mockPaymentSchedule.getPaymentAmount();
		mockPaymentSchedule.getPaymentAmount();
		mockPaymentSchedule.getPaymentStatus();
		mockPaymentSchedule.getPrincipal();
		mockPaymentSchedule.getProjectedInterest();
		
		logger.debug(mockPaymentSchedule.toString());
		
	}
	
//	@org.junit.jupiter.api.Test
//	void testget_PaymentSchedule() {
//		
//		PaymentScheduleRepository paymentScheduleRepository = mock(PaymentScheduleRepository.class);
//		PaymentSchedule mockPaymentSchedule =new PaymentSchedule(0,LocalDate.of(2021,5,12),0,180,"projected",180);
//		mockPaymentSchedule.setPaymentScheduleId(0);
//		
////		when(paymentScheduleRepository.findById(0)).thenReturn(mockPaymentSchedule);
//	
//		PaymentScheduleService paymentScheduleService=new PaymentScheduleService(paymentScheduleRepository);
//		doReturn(mockPaymentSchedule).when(paymentScheduleRepository).findById(0);
//		PaymentSchedule actualPaymentSchedule=paymentScheduleService.get(0);
//		PaymentSchedule expectedPaymentSchedule=new PaymentSchedule(0,LocalDate.of(2021,5,12),0,180,"projected",180);
//		expectedPaymentSchedule.setPaymentScheduleId(0);
//		assertEquals(expectedPaymentSchedule,actualPaymentSchedule);
//	}
	
//	
//	@org.junit.jupiter.api.Test
//	void testPrincipleInterestOnlyYearlyTwoYear() {
//		
//		System.out.println("inside test");
//		PaymentScheduleService PaymentScheduleService =new PaymentScheduleService();
//		Loan loan = new Loan(10001,3600,LocalDate.of(2020,11,2),LocalDate.of(2020, 11, 12),LocalDate.of(2021, 11, 12),1,10,2,"interestOnly");
//		System.out.println(loan.getCustomerId());
//		List<PaymentSchedule>acualPaymentScheduleList =PaymentScheduleService.save(loan);
//		System.out.println(acualPaymentScheduleList);
//		List<PaymentSchedule>expectedPaymentScheduleList = new ArrayList<PaymentSchedule>(); 
//		
//		PaymentSchedule paymentSchedule = new PaymentSchedule(0,LocalDate.of(2021,11,12),0,360,"projected",360);
//		expectedPaymentScheduleList.add(paymentSchedule);
//	    paymentSchedule = new PaymentSchedule(0,LocalDate.of(2022,11,12),3600,360,"projected",3960);
//		expectedPaymentScheduleList.add(paymentSchedule);
//	
//
//		System.out.println(expectedPaymentScheduleList);
//		assertIterableEquals(expectedPaymentScheduleList, acualPaymentScheduleList);
//	}
//	
}







//@InjectMocks
//private PaymentScheduleService paymentScheduleService;
//
//@Mock
//PaymentScheduleRepository paymentScheduleRepository;
//
//@BeforeEach
//void setUP() {
//	MockitoAnnotations.initMocks(this);
//}
//MockitoAnnotations.initMocks(this);
//
//PaymentSchedule mockPaymentSchedule =new PaymentSchedule(0,LocalDate.of(2021,5,12),0,180,"projected",180);
//PaymentScheduleRepository paymentScheduleRepository =Mockito.mock(PaymentScheduleRepository.class);
//when(paymentScheduleRepository.save(any())).thenReturn(mockPaymentSchedule) ;

//doAnswer(invocation -> mockPaymentSchedule).when(paymentScheduleRepository.save(any(PaymentSchedule.class))).thenReturn(mockPaymentSchedule);

//when(paymentScheduleRepository.save(any(PaymentSchedule.class))).thenReturn(mockPaymentSchedule);
//  .thenThrow(RuntimeException.class);
//verify(paymentScheduleRepository, times(3)).save(any(PaymentSchedule.class));

	


//when(passwordEncoder.encode("1")).thenReturn();

//when(paymentScheduleRepository.save(any(PaymentSchedule.class))).thenReturn(mockPaymentSchedule);
//when(paymentScheduleRepository.save(any())).thenReturn(null);

//MockitoAnnotations.initMocks(this);

//doNothing().when(paymentScheduleRepository).save(any());
//.thenThrow(RuntimeException.class);


//verify(paymentScheduleRepository, times(1000)).save(any());
//verify(paymentScheduleRepository).save(any());

// doNothing().
// doThrow(new RuntimeException()).when(paymentScheduleRepository).save(new PaymentSchedule()).thenThrow(RuntimeException.class);

//when(paymentScheduleRepository.save(any())).thenReturn(null);

// when(paymentScheduleRepository.save( any())).thenThrow(RuntimeException.class);

//doNothing().when(paymentScheduleRepository).save(any());

// doReturn(null).when(paymentScheduleRepository).save(any());

//doNothing().when(paymentScheduleRepository).save(any(PaymentSchedule.class));

//in28minutes
//SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);
//int result = businessImpl.findTheGreatestFromAllData();
//assertEquals(24, result);