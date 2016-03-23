package pl.spaszek.ds.domain.courier.repository;


import org.junit.Test;
import pl.spaszek.ds.domain.courier.entity.Courier;
import pl.spaszek.ds.domain.courier.objectmother.CourierObjectMother;

import java.util.Collection;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.newArrayList;
import static org.assertj.core.api.Assertions.assertThat;

public class CourierFakeRepositoryTest {

    private final CourierFakeRepository courierFakeRepository = new CourierFakeRepository();

    @Test
    public void shouldProperlyCount() throws Exception {
        //given
        courierFakeRepository.addForTesting(newArrayList(CourierObjectMother.createFakeCourier(1L), CourierObjectMother.createFakeCourier(2L), CourierObjectMother.createFakeCourier(3L)));

        //when
        final long result = courierFakeRepository.countAll();

        //then
        assertThat(result).isEqualTo(3L);
    }

    @Test
    public void shouldReturnAll() throws Exception {
        //given
        courierFakeRepository.addForTesting(newArrayList(CourierObjectMother.createFakeCourier(1L), CourierObjectMother.createFakeCourier(2L), CourierObjectMother.createFakeCourier(3L)));

        //when
        final Collection<Courier> result = courierFakeRepository.findAll();

        //then
        assertThat(result.stream().map(Courier::getId).collect(Collectors.toList())).containsExactly(1L,2L,3L);
    }

    @Test
    public void shouldPersistNewEntity() throws Exception {
        //given
        Courier courier = CourierObjectMother.createFakeCourier(1L);

        //when
        courierFakeRepository.save(courier);

        //then
        assertThat(courierFakeRepository.countAll()).isEqualTo(1L);
    }


    @Test
    public void shouldProperlyMergeEntities() throws Exception {
        //given
        final Courier dbCourier = CourierObjectMother.createFakeCourier(1L);
        dbCourier.setRate(1.5f);

        courierFakeRepository.addForTesting(newArrayList(dbCourier));

        final Courier editedCourier = CourierObjectMother.createFakeCourier(1L);
        editedCourier.setRate(3.5f);

        //when
        final Courier result = courierFakeRepository.save(editedCourier);

        //then
        assertThat(courierFakeRepository.countAll()).isEqualTo(1L);
        assertThat(courierFakeRepository.find(1L)).isPresent().hasValueSatisfying(e -> assertThat(e.getRate()).isEqualTo(3.5f));

    }

    @Test
    public void shouldDeleteEntity() throws Exception {
        //given
        final Courier dbCourier = CourierObjectMother.createFakeCourier(1L);

        courierFakeRepository.addForTesting(newArrayList(dbCourier));

        //when
        courierFakeRepository.delete(dbCourier);

        //then
        assertThat(courierFakeRepository.countAll()).isEqualTo(0L);

    }






}