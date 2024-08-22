import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetalleNoticiasComponent } from './detalle-noticias.component';

describe('DetalleNoticiasComponent', () => {
  let component: DetalleNoticiasComponent;
  let fixture: ComponentFixture<DetalleNoticiasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetalleNoticiasComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DetalleNoticiasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
