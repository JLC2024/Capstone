import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeletemedicineComponent } from './deletemedicine.component';

describe('DeletemedicineComponent', () => {
  let component: DeletemedicineComponent;
  let fixture: ComponentFixture<DeletemedicineComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DeletemedicineComponent]
    });
    fixture = TestBed.createComponent(DeletemedicineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
