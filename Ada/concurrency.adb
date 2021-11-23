with Ada.Text_IO;
use Ada.Text_IO;

procedure Concurrency is
  task T;

  task body T is
   begin
      for I in Character range '1' .. '9' loop
         Put_Line(I'Image);
      end loop;
   end T;
begin
   for I in Character range 'A' .. 'Z' loop
      Put_Line(I'Image);
   end loop;
end Concurrency;
